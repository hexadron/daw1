package app.dao.interfaces;

import app.beans.Usuario;

public interface UsuarioDAO {
	public Usuario authenticate(Usuario usuario);
}