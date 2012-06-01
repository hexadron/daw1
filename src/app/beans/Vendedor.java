package app.beans;

import app.util.ActiveRecord;

public class Vendedor extends ActiveRecord {

	private static final long serialVersionUID = 1L;
	
	private long id;
	private String nombre;
	private String apellido;
	private String password;
	private int edad;
	private String fechaNacimiento;
	private EstadoCivil estadoCivil;
	private Distrito distrito;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	
	public Distrito getDistrito() {
		return distrito;
	}

	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
	}

	@Override
	public String toString() {
		return "{\"id\":\"" + id + "\", \"nombre\":\"" + nombre + "\", \"apellido\":\""
				+ apellido + "\", \"edad\":\"" + edad + "\", \"fechaNacimiento\":\""
				+ fechaNacimiento + "\", \"estadoCivil\":\"" + estadoCivil
				+ "\", \"distrito\":\"" + distrito + "\"}";
	}	

}
