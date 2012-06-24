package app.service;

import app.beans.Usuario;

public interface LoginService {
	
	public Usuario authenticate(Usuario usuario);
}
