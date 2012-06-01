package app.dao.interfaces;

import java.util.*;

import app.beans.Vendedor;

public interface VendedorDAO {
	
	public boolean autenticar(String nombre, String password);
	
	public Vendedor findById(long id);
	
	public List<Vendedor> findAll();

	public Vendedor actualizarVendedor(Vendedor vendedor);

	public void eliminarVendedor(long codigo);

}
