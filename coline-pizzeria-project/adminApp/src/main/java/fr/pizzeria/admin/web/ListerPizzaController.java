package fr.pizzeria.admin.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.dao.PizzaDaoJpa;
import fr.pizzeria.model.Pizza;

/**
 * Servlet implementation class ListerPizzaController
 */
public class ListerPizzaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListerPizzaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ResourceBundle bundle = ResourceBundle.getBundle("application");
	    String daoConfig = bundle.getString("dao.impl");
		
        PizzaDaoJpa daoFactory;
        try {
            daoFactory = (PizzaDaoJpa) Class.forName(daoConfig).newInstance();
            List<Pizza> pizzas = daoFactory.findAllPizzas();
            
            request.setAttribute("Pizzas", pizzas);
            RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/test.jsp");
            dispatcher.forward(request, response);
            
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
        
   
       

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
