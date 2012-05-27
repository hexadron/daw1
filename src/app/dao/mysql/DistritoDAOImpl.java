package app.dao.mysql;

import java.util.List;

import app.beans.Distrito;
import app.dao.interfaces.DistritoDAO;

public class DistritoDAOImpl implements DistritoDAO {

	@Override
	public List<Distrito> findAll() {
		return Distrito.all(Distrito.class);
	}

}
