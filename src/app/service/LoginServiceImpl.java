package app.service;

import app.dao.factories.DAOFactory;
import app.dao.interfaces.UsuarioDAO;
import app.beans.Usuario;

// Caso de Uso Login

public class LoginServiceImpl implements LoginService {
	
	DAOFactory daoFactory=
			DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	
	UsuarioDAO usuarioDao = daoFactory.getUsuarioDAO();

	public Usuario authenticate(Usuario usuario) {
		return usuarioDao.authenticate(usuario);
	}
	
}