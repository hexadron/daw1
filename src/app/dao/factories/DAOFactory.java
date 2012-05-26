package app.dao.factories;

import app.dao.interfaces.VendedorDAO;

public abstract class DAOFactory {

	public static final int MYSQL = 1;

	public abstract VendedorDAO getVendedorDAO();

	public static DAOFactory getDAOFactory(int whichFactory) {
		switch (whichFactory) {
		case MYSQL:
			return new MySQLDAOFactory();
		default:
			return null;
		}
	}

}
