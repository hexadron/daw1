package app.util;

import java.io.Serializable;
import java.lang.reflect.*;
import java.sql.*;
import java.util.*;
import static app.util.Utilities.*;

@SuppressWarnings("serial")
public abstract class ActiveRecord implements Serializable {
	
	public static <T> T find(Class<? extends ActiveRecord> c, long id) {
		try {
			return c.newInstance().find(id);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public <T> T find(long id) {
		Connection db = null;
		String sql = "SELECT * FROM " + getTable() + " WHERE " + getIdField() + " = ?";
		try {
			db = Database.getConnection();
			PreparedStatement ps = db.prepareStatement(sql);
			ps.setLong(1, id);
			
			ResultSet rs = ps.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			
			if (rs.next()) {
				String colname, name;
				T o = (T) getClass().newInstance();
				for (int i = 1; i <= rsmd.getColumnCount(); i++) {
					colname = rsmd.getColumnName(i);
					name = colname.endsWith("_id") ? colname.replace("_id", "") : colname;
					Object val = rs.getObject(colname);
					if (val != null) {
						Method m = getSetter(name);
						Class<?> type = m.getParameterTypes()[0];
						if (type.getSuperclass() != null &&
								type.getSuperclass().equals(this.getClass().getSuperclass()))
							m.invoke(o, find((Class<? extends ActiveRecord>) type, (Integer)val));
						else
							m.invoke(o, val);
					}
				}
				return o;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Database.close(db);
		}
		return null;
	}
	
	public static <T> List<T> all(Class<? extends ActiveRecord> c) {
		try {
			return c.newInstance().where("1 = 1");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static <T> List<T> where(Class<? extends ActiveRecord> c, String query, Object... values) {
		try {
			return c.newInstance().where(query, values);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public <T> List<T> where(String query, Object... values) {
		List<T> all = new ArrayList<T>();
		Connection db = null;
		String sql = "SELECT * FROM " + getTable() + " WHERE ";
		
		if (query.split(" ").length > 1) // si contiene una condicion, e.g.: algo = ?
			sql += query; 
		else
			sql += query + " = ?";
		try {
			db = Database.getConnection();
			PreparedStatement ps = db.prepareStatement(sql);
			
			for (int i = 0; i < values.length; i++)
				ps.setObject(i + 1, values[i]);
			
			ResultSet rs = ps.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			
			while (rs.next()) {
				String name, colname;
				T o = (T) getClass().newInstance();
				for (int i = 1; i <= rsmd.getColumnCount(); i++) {
					colname = rsmd.getColumnName(i); 
					name = colname.endsWith("_id") ? colname.replace("_id", "") : colname;
					Object val = rs.getObject(colname);
					if (val != null) {
						Method m = getSetter(name);
						Class<?> type = m.getParameterTypes()[0];
						if (type.getSuperclass() != null &&
								type.getSuperclass().equals(this.getClass().getSuperclass())) {
							m.invoke(o, find((Class<? extends ActiveRecord>) type, (Integer) val));
						} else {
							m.invoke(o, val);
						}
					}
				}
				all.add(o);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Database.close(db);
		}
		return all;
	}
	
	@SuppressWarnings("unchecked")
	public <T> T save() {
		if (getGetter(getIdField()) != null) {
			try {
				Object id = getGetter(getIdField()).invoke(this);
				if (id.toString().equals("0"))
					create();
				else
					update();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			create();
		}
		return (T) this;
	}
	
	@SuppressWarnings("unchecked")
	public <T> T create() {
		Connection db = null;
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO " + getTable() + " (");
		String[] fields = getTableFields().split(", ");
		
		for (int i = 0; i < fields.length; i++)
			sql.append(fields[i]).append(", ");
		
		sql.delete(sql.length() - 2, sql.length());
		sql.append(") VALUES (");
		
		for (int i = 0; i < fields.length; i++)
			sql.append("?, ");
		
		sql.delete(sql.length() - 2, sql.length());
		sql.append(")");
		try {
			db = Database.getConnection();
			PreparedStatement ps = db.prepareStatement(sql.toString(), 
						Statement.RETURN_GENERATED_KEYS);
			for (int i = 0; i <= fields.length - 1; i++) {
				Field f = null;
				if (fields[i].endsWith("_id"))
					f = getClass().getDeclaredField(fields[i].
							substring(0, fields[i].length() - 3));
				else
					f = getClass().getDeclaredField(fields[i]);
				if (f.getType().getSuperclass() != null &&
						f.getType().getSuperclass().equals(this.getClass().getSuperclass())) {
					Method idGetter = null;
					Object obj = getGetter(f.getName()).invoke(this);
					if (obj.getClass().getMethod("get" + capitalize(((ActiveRecord) obj).getIdField())) != null)
						idGetter = obj.getClass().getMethod("get" + capitalize(((ActiveRecord) obj).getIdField()));
					ps.setObject(i + 1, idGetter.invoke(obj));
				} else
					ps.setObject(i + 1, getGetter(f.getName()).invoke(this));
			}
			
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			
			if (rs.next()) {
				Method m = getSetter(getIdField());
				if (m != null)
					m.invoke(this, rs.getLong(1));
			}
			return (T) this;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Database.close(db);
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public <T> T update() {
		Connection db = null;
		
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE " + getTable() + " SET ");
		String[] fields = getTableFields().split(", ");
		
		for (int i = 0; i < fields.length; i++)
			sql.append(fields[i]).append(" = ?, ");
		
		sql.delete(sql.length() - 2, sql.length());
		sql.append(" WHERE " + getIdField() + " = ?");
		try {
			db = Database.getConnection();
			PreparedStatement ps = db.prepareStatement(sql.toString());
			
			int i = 0;
			for (; i++ <= fields.length - 1;) {
				Field f = null;
				if (fields[i - 1].endsWith("_id"))
					f = getClass().getDeclaredField(fields[i - 1].substring(0, fields[i - 1].length() - 3));
				else
					f = getClass().getDeclaredField(fields[i - 1]);
				if (f.getType().getSuperclass() != null && 
						f.getType().getSuperclass().equals(this.getClass().getSuperclass())) {
					Method idGetter = null;
					Object obj = getGetter(f.getName()).invoke(this);
					if (obj.getClass().getMethod("get" + capitalize(((ActiveRecord) obj).getIdField())) != null)
						idGetter = obj.getClass().getMethod("get" + capitalize(((ActiveRecord) obj).getIdField()));
					ps.setObject(i, idGetter.invoke(obj));
				} else {
					ps.setObject(i, getGetter(f.getName()).invoke(this));
				}
			}
		
			ps.setLong(i, (Long) getGetter(getIdField()).invoke(this));
			ps.executeUpdate();
			return (T) this;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Database.close(db);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public <T> T delete() {
		Connection db = null;
		String sql = "DELETE FROM " + getTable() + " WHERE " + getIdField() + " = ?";
		try {
			db = Database.getConnection();
			PreparedStatement ps = db.prepareStatement(sql);
			ps.setLong(1, (Long) getGetter(getIdField()).invoke(this));
			ps.executeUpdate();
			return (T) this;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Database.close(db);
		}
		return null;
	}
	
	public static <T> T delete(Class<? extends ActiveRecord> c, long id) {
		Connection db = null;
		try {
			T o = c.newInstance().find(id);
			String sql = "DELETE FROM " + ((ActiveRecord) o).getTable() + " WHERE " + 
					((ActiveRecord) o).getIdField() + " = ?";
			db = Database.getConnection();
			PreparedStatement ps = db.prepareStatement(sql);
			ps.setLong(1, id);
			ps.executeUpdate();
			return o;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Database.close(db);
		}
		return null;
	}
	
	public String getTableFields() {
		Connection db = null;
		try {
			db = Database.getConnection();

			StringBuilder fields = new StringBuilder();
			PreparedStatement ps = db.prepareStatement("describe " + getTable());
			ResultSet rs = ps.executeQuery();
			
			while (rs.next())
				if (!(rs.getString(1).equals(getIdField())))
					fields.append(rs.getString(1)).append(", ");
			
			fields.delete(fields.lastIndexOf(","), fields.length());

			return fields.toString();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Database.close(db);
		}
		return null;
	}
	
	private Method getGetter(String field) {
		return getGetter(field, getClass());
	}
	
	private Method getGetter(String field, Class<?> c) {
		for (Method m : c.getDeclaredMethods())
			if (m.getName().startsWith("get"))
				if (m.getName().toLowerCase().endsWith(field.toLowerCase()))
					return m;
		return null;
	}
	
	private Method getSetter(String field) {
		return getSetter(field, getClass());
	}
	
	private Method getSetter(String field, Class<?> c) {
		for (Method m : c.getDeclaredMethods())
			if (m.getName().startsWith("set"))
				if (m.getName().toLowerCase().endsWith(field.toLowerCase()))
					return m;
		return null;
	}

	public String getTable() {
		return getTable(getClass().getSimpleName());
	}
	
	private String getTable(String name) {
		return name.toLowerCase().toString();
	}
	
	protected String getIdField() {
		return "id";
	}

	public static void truncate(Class<? extends ActiveRecord> model) {
		try {
			model.newInstance().truncate();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	public void truncate() {		
		Connection db = null;
		try {
			db = Database.getConnection();

			PreparedStatement ps = db.prepareStatement("truncate " + getTable());
			ps.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Database.close(db);
		}		
		
	}

}