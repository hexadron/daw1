package app.dao.mysql;

import java.util.List;

import app.beans.Vendedor;
import app.dao.interfaces.VendedorDAO;

public class VendedorDAOImpl implements VendedorDAO {

	@Override
	public boolean autenticar(String nombre, String password) {
		int size = Vendedor.where(Vendedor.class, "nombre = ? and password = ?", nombre, password).size();
		return size > 0 ? true : false;
	}
	
	@Override
	public Vendedor findById(long id) {
		return Vendedor.find(Vendedor.class, id);
	}

	@Override
	public List<Vendedor> findAll() {
		return Vendedor.all(Vendedor.class);
	}

	@Override
	public Vendedor actualizarVendedor(Vendedor vendedor) {
		return vendedor.save();
	}

	@Override
	public void eliminarVendedor(long codigo) {
		Vendedor.delete(Vendedor.class, codigo);
	}

}
