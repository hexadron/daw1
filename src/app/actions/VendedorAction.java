package app.actions;

import java.util.List;

import app.beans.Distrito;
import app.beans.EstadoCivil;
import app.beans.Vendedor;
import app.services.*;
import app.util.Constantes;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class VendedorAction extends ActionSupport {
	
	private VendedorService service = GestionVendedorBusinessDelegate.getVendedorService();

	private Vendedor vendedor;
	private EstadoCivil estadoCivil;
	private Distrito distrito;
	private List<Vendedor> vendedores;
	long codigo;

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
	
	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public Distrito getDistrito() {
		return distrito;
	}

	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
	}

	public long getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public String loginVendedor() throws Exception {
		if (service.autenticar(vendedor.getNombre(), vendedor.getPassword())) {
			vendedores = service.obtenerTodos();
			return Constantes.VENDEDOR_LIST;
		} else {
			addActionError(getText("error.login"));
			return Constantes.VENDEDOR_LOGIN;
		}
	}
	
	public String actualizarVendedor() throws Exception {
		vendedor.setDistrito((Distrito) Distrito.find(Distrito.class, distrito.getId()));
		vendedor.setEstadoCivil((EstadoCivil) EstadoCivil.find(EstadoCivil.class, estadoCivil.getId()));
		service.actualizarVendedor(vendedor);
		vendedores = service.obtenerTodos();
		return Constantes.VENDEDOR_LIST;
	}
	
	public String eliminarVendedor() throws Exception {
		if (Vendedor.find(Vendedor.class, codigo) != null) {
			service.eliminarVendedor(codigo);
		}
		vendedores = service.obtenerTodos();
		return Constantes.VENDEDOR_LIST;
	}
	
	public String detalleVendedor() throws Exception {
		vendedor = service.obtenerPorCodigo(codigo);
		return Constantes.VENDEDOR_DETAIL;
	}
	
	public String listadoVendedor() throws Exception {
		vendedores = service.obtenerTodos();
		return Constantes.VENDEDOR_LIST;
	}
	
	public String cargarVendedor() throws Exception {
		vendedor = service.obtenerPorCodigo(codigo);
		return Constantes.VENDEDOR_EDIT;
	}
	
}
