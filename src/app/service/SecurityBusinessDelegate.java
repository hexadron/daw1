package app.service;

// Paquete de Análisis "Seguridad"
public class SecurityBusinessDelegate {

	public static LoginService getLoginService() {
		return new LoginServiceImpl();
	}

}
