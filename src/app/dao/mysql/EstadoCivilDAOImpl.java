package app.dao.mysql;

import java.util.List;

import app.beans.EstadoCivil;
import app.dao.interfaces.EstadoCivilDAO;

public class EstadoCivilDAOImpl implements EstadoCivilDAO {

	@Override
	public List<EstadoCivil> findAll() {
		return EstadoCivil.all(EstadoCivil.class);
	}

}
