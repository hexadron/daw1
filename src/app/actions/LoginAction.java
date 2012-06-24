package app.actions;

import app.beans.Usuario;

import com.opensymphony.xwork2.ActionSupport;

import app.service.SecurityBusinessDelegate;
import app.service.LoginService;

public class LoginAction extends ActionSupport {
	
	private Usuario usuario;
	
	private LoginService loginService =
			SecurityBusinessDelegate.getLoginService();
	
	public String login() throws Exception {
		usuario = new Usuario();
		return LOGIN;
	}
	
	public String authenticate() throws Exception {
		Usuario auth = loginService.authenticate(usuario);
		if (auth != null)
			return SUCCESS;
		else {
			addActionError("Authentication Failed");
			return ERROR;
		}
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}