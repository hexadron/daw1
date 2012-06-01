package app.services;

import java.util.List;

import app.beans.Vendedor;

public interface VendedorService {
	
	public boolean autenticar(String nombre, String password);

	public List<Vendedor> obtenerTodos();
	
	public Vendedor obtenerPorCodigo(long codigo);

	public Vendedor actualizarVendedor(Vendedor vendedor);
	
	public void eliminarVendedor(long codigo);

}
