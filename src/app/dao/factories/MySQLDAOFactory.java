package app.dao.factories;

import app.dao.interfaces.*;
import app.dao.mysql.*;

public class MySQLDAOFactory extends DAOFactory {

	@Override
	public VendedorDAO getVendedorDAO() {
		return new VendedorDAOImpl();
	}

	@Override
	public DistritoDAO getDistritoDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EstadoCivilDAO getEstadoCivilDAO() {
		// TODO Auto-generated method stub
		return null;
	}

}
