package fr.pizzeria.admin.web;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.admin.metier.ClientServiceEJB;

@WebServlet(urlPatterns="/clients")
public class ListerClientController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private ClientServiceEJB ejb;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("Clients", ejb.findAllClients());
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/clients.jsp");
		dispatcher.forward(request, response);
		
	}
}
