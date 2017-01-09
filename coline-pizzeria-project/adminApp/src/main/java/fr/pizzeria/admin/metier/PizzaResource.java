package fr.pizzeria.admin.metier;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.pizzeria.model.Pizza;

@Path("/pizzas")
public class PizzaResource {
	@Inject
	private PizzaServiceEJB p;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Pizza> findAllPizzas(){
		return p.findAllPizzas();		
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Pizza saveNewPizza(Pizza pizza) {
		return p.saveNewPizza(pizza);
	}
	
	@PUT
	@Path("/{code}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public boolean updatePizza(@PathParam("code") String codePizza, Pizza pizza) {
		return p.updatePizza(codePizza, pizza);		
	}
	
	@DELETE
	@Path("/{code}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public boolean deletePizza(@PathParam("code") String codePizza) {
		return p.deletePizza(codePizza);
	}


	public Pizza findPizzaByCode(String codePizza) {
	
	    return p.findPizzaByCode(codePizza);
	}
	/*public boolean isCodeExist(String codePizza) {
		return pizzaJpa.isCodeExist(codePizza);

	}*/
}
