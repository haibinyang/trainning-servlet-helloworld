package top.yhb123;

import javax.servlet.*;
import top.yhb123.model.Dog;

public class MyServletContextListener implements ServletContextListener {
	
	public void contextInitialized(ServletContextEvent event) {
		ServletContext sc = event.getServletContext();
		String dogBreed = sc.getInitParameter("breed");
		Dog d = new Dog(dogBreed);
		sc.setAttribute("dog",d);
	}
	
	public void contextDestroyed(ServletContextEvent event) {
	}
}