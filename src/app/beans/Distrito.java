package app.beans;

import app.util.ActiveRecord;

public class Distrito extends ActiveRecord {

	private static final long serialVersionUID = 1L;
	
	private long id;
	private String descripcion;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	@Override
	public String toString() {
		return "{\"id\":\"" + id + "\", \"descripcion\":\"" + descripcion + "\"}";
	}

}
