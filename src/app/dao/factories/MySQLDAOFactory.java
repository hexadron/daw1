package app.dao.factories;

import app.dao.interfaces.*;
import app.dao.mysql.*;

public class MySQLDAOFactory extends DAOFactory {

	@Override
	public VendedorDAO getVendedorDAO() {
		return new VendedorDAOImpl();
	}

}
