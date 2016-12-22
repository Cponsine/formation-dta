package fr.pizzeria.admin.web;



import java.io.IOException;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.Exception.DeletePizzaException;
import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.dao.PizzaDaoJpa;

/**
 * Servlet implementation class SupprPizzaController
 */
public class SupprPizzaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupprPizzaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response){
		String code = request.getParameter("code");
		ResourceBundle bundle = ResourceBundle.getBundle("application");
	    String daoConfig = bundle.getString("dao.impl");
        
		try {
			PizzaDao dao = (PizzaDaoJpa) Class.forName(daoConfig).newInstance();
			if (dao.findAllPizzas().stream().filter(p -> p.getCode().equals(code)).findFirst().isPresent()) {
									
					dao.deletePizza(code);
					response.sendRedirect("/pizzeria-admin-app/api/servlet/list");				
			}
		} catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException | IOException e) {
			// Génerer lees pages d'erreurs --> impossible de trouver la pizza
			// dans interface via la liste
			e.printStackTrace();
		}
	}
}
