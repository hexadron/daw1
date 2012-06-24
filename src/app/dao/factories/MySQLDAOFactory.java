package app.dao.factories;

import app.dao.mysql.UsuarioDAOImpl;
import app.dao.interfaces.UsuarioDAO;

public class MySQLDAOFactory extends DAOFactory {

	@Override
	public UsuarioDAO getUsuarioDAO() {
		return new UsuarioDAOImpl();
	}


}
