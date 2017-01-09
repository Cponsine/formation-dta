package fr.pizzeria.admin.web;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.admin.metier.PizzaServiceEJB;

/**
 * Servlet implementation class ListerPizzaController
 */
@WebServlet(urlPatterns="/tespizzas")
public class ListerPizzaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//@Inject private PizzaService ps = new PizzaService();
	@EJB private PizzaServiceEJB ejb;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListerPizzaController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		request.setAttribute("Pizzas", ejb.findAllPizzas());
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/test.jsp");
		dispatcher.forward(request, response);
		/*avant CDI
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
            
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
           
            e.printStackTrace();
        }
        catch (SQLException e) {
           
            e.printStackTrace();
        }*/
    }
        
   
       

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
