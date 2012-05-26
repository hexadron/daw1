package app.dao.interfaces;

import java.util.*;

import app.beans.Vendedor;

public interface VendedorDAO {
	
	public Vendedor findById(long id);
	
	public List<Vendedor> findAll();

}
