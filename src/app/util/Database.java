package app.util;

import java.sql.*;

import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSource;

public class Database {

	private static BasicDataSource source = getDataSource();

	private Database() {}
	
	public static DataSource source() {
		return source;
	}

	public static Connection getConnection() {
		try {
			return source.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private static BasicDataSource getDataSource() {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUsername("root");
		ds.setPassword("");
		ds.setUrl("jdbc:mysql://localhost/daw1");
		return ds;
	}

	public static void close(Connection db) {
		try {
			if (db != null && !db.isClosed())
				db.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
