package top.yhb123;

import top.yhb123.model.BeerExpert;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class BeerSelect extends HttpServlet {
	
	public void doPost(HttpServletRequest request,
					HttpServletResponse response)
					throws IOException, ServletException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("Beer Selection Advice<br>");

		String color = request.getParameter("color");
		BeerExpert be = new BeerExpert();
		List result = be.getBrands(color);

		Iterator it = result.iterator();
		while (it.hasNext()) {
			out.print("<br/>try: " + it.next());
		}
	}		
}
