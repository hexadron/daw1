package app.dao.mysql;

import java.util.List;

import app.beans.Vendedor;
import app.dao.interfaces.VendedorDAO;

public class VendedorDAOImpl implements VendedorDAO {

	@Override
	public Vendedor findById(long id) {
		return Vendedor.find(Vendedor.class, id);
	}

	@Override
	public List<Vendedor> findAll() {
		return Vendedor.all(Vendedor.class);
	}

}
