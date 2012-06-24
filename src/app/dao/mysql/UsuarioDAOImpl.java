package app.dao.mysql;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import app.beans.Usuario;
import app.dao.interfaces.UsuarioDAO;
import app.dao.mybatis.config.SessionFactory;
import app.dao.mybatis.mappers.UsuarioMapper;

public class UsuarioDAOImpl implements UsuarioDAO {
	
	private SqlSessionFactory factory;
	
	{
		factory = SessionFactory.getSqlSessionFactory();
	}

	public Usuario authenticate(Usuario usuario) {
		SqlSession session = factory.openSession();
		try {
			UsuarioMapper mapper = session.getMapper(UsuarioMapper.class);
			return  mapper.aunthenticate(usuario.getLogin(), usuario.getPassword());
		} finally {
			session.close();
		}
		
	}

}
