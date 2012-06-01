package app.listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import app.beans.Distrito;
import app.beans.EstadoCivil;

@WebListener
public class ListsListener implements ServletContextListener {

    public ListsListener() {}

    public void contextInitialized(ServletContextEvent ctx) {
    	try {
			ServletContext context = ctx.getServletContext();
			context.setAttribute("estadosCiviles", EstadoCivil.all(EstadoCivil.class));
			context.setAttribute("distritos", Distrito.all(Distrito.class));
    	} catch (Exception e) {
			e.printStackTrace();
		}
    }

    public void contextDestroyed(ServletContextEvent ctx) {

    }
	
}
