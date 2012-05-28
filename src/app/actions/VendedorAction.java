package app.actions;

import java.util.List;

import app.beans.Vendedor;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class VendedorAction extends ActionSupport {

	private Vendedor vendedor;
	private List<Vendedor> vendedores;

	public List<Vendedor> getVendedores() {
		return vendedores;
	}

	public void setVendedores(List<Vendedor> vendedores) {
		this.vendedores = vendedores;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

}
