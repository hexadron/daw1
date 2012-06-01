package app.services;

public class GestionVendedorBusinessDelegate {
	
	public static VendedorService getVendedorService() {
		return new VendedorServiceImpl();
	}

}
