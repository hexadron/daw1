package app.services;

import java.util.List;

import app.beans.Vendedor;
import app.dao.factories.DAOFactory;
import app.dao.interfaces.VendedorDAO;

public class VendedorServiceImpl implements VendedorService {

	DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	VendedorDAO dao = factory.getVendedorDAO();
	
	@Override
	public boolean autenticar(String nombre, String password) {
		return dao.autenticar(nombre, password);
	}

	@Override
	public List<Vendedor> obtenerTodos() {
		return dao.findAll();
	}

	@Override
	public Vendedor obtenerPorCodigo(long id) {
		return dao.findById(id);
	}

	@Override
	public Vendedor actualizarVendedor(Vendedor vendedor) {
		return dao.actualizarVendedor(vendedor);
	}

	@Override
	public void eliminarVendedor(long codigo) {
		dao.eliminarVendedor(codigo);
	}

}
