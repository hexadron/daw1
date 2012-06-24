package app.dao.mybatis.config;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SessionFactory {
	protected static final SqlSessionFactory FACTORY;
	
	static {
		try {
			Reader reader =
				Resources.getResourceAsReader("app/dao/mybatis/config/mybatis-config.xml");
			FACTORY = new SqlSessionFactoryBuilder().build(reader);
			FACTORY.getConfiguration().addMappers("app.dao.mybatis.mappers");
			
		} catch(Exception ex) {
			throw new RuntimeException();
		}
	}
	
	public static SqlSessionFactory getSqlSessionFactory() {
		return FACTORY;
	}
	
}