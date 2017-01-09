package fr.pizzeria.admin.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.Exception.DeletePizzaException;
import fr.pizzeria.Exception.UpdatePizzaException;
import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.dao.PizzaDaoJpa;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

/**
 * Servlet implementation class PizzaServletWebApi
 */
@WebServlet("/blabla")
public class PizzaServletWebApi extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final transient PizzaDao pizzaDao = new PizzaDaoJpa();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PizzaServletWebApi() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
			List<Pizza> list=null;
			try {
				list = pizzaDao.findAllPizzas();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			PrintWriter out = response.getWriter();
			list.forEach(p -> out.write(
					p.getId() + " " + p.getCode() + " " + p.getNom() + " " + p.getPrix() + " " + p.getCat() + "\n"));
			out.write(Pizza.getNbPizzas() + "\n");
		}
		//response.getWriter().append("Coucou Served at: ").append(request.getContextPath());

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		String code = request.getParameter("code");
		String nom = request.getParameter("nom");
		String prix = request.getParameter("prix");
		CategoriePizza catP = CategoriePizza.valueOf(request.getParameter("cat"));
		Pizza pizza = new Pizza(Pizza.getNbPizzas(),code, nom, Double.parseDouble(prix), catP);
		pizzaDao.saveNewPizza(pizza);
		response.setStatus(201);
	}

	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response) {
		String codePizza = request.getParameter("codePizza");
		String code = request.getParameter("code");
		String nom = request.getParameter("nom");
		String prix = request.getParameter("prix");
		CategoriePizza catP = CategoriePizza.valueOf(request.getParameter("cat"));
		Pizza pizza = new Pizza(null,code, nom, Double.parseDouble(prix), catP);
		try {
			pizzaDao.updatePizza(codePizza, pizza);
		} catch (UpdatePizzaException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) {
		String codePizza = request.getParameter("codePizza");
		try {
			pizzaDao.deletePizza(codePizza);
		} catch (DeletePizzaException | SQLException e) {
			
			e.printStackTrace();
		}
	}
}
