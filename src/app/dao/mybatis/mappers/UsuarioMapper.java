package app.dao.mybatis.mappers;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import app.beans.Usuario;

public interface UsuarioMapper {
	String auth =
			"select * from Usuario where login = #{login} and password = #{password}";
	
	@Select(auth)
	@Results(value = {
	        @Result (property="id"),
	        @Result (property="login", column="login"),
	        @Result (property="password", column="password"),
	        @Result (property="nombres", column="nombres"),
	        @Result (property="apellidos", column="apellidos")
	    })
	
	Usuario aunthenticate(@Param("login") String login, @Param("password") String password);
}