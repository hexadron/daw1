package app.dao.factories;

import app.dao.interfaces.UsuarioDAO;

public abstract class DAOFactory {

	public static final int MYSQL = 1;

	public static DAOFactory getDAOFactory(int whichFactory) {
		switch (whichFactory) {
		case MYSQL:
			return new MySQLDAOFactory();
		default:
			return null;
		}
	}
	
	public abstract UsuarioDAO getUsuarioDAO();

}
