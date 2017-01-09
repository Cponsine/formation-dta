package fr.pizzeria.admin.metier;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import fr.pizzeria.Exception.DeletePizzaException;
import fr.pizzeria.Exception.SavePizzaException;
import fr.pizzeria.Exception.UpdatePizzaException;
import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.dao.PizzaDaoJpa;
import fr.pizzeria.model.Pizza;

public class PizzaService {

	private PizzaDao pizzaJpa;
    
	public PizzaService(){
     
    ResourceBundle bundle = ResourceBundle.getBundle("application");
    String daoConfig = bundle.getString("dao.impl");

        try {
			pizzaJpa = (PizzaDaoJpa) Class.forName(daoConfig).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	//@Inject private PizzaDaoJpa pizzaJpa;
	
	public List<Pizza> findAllPizzas() throws SQLException {
		return pizzaJpa.findAllPizzas();
	}
	
	public boolean saveNewPizza(Pizza pizza) throws SavePizzaException {
		return pizzaJpa.saveNewPizza(pizza);
	}

	public boolean updatePizza(String codePizza, Pizza pizza) throws UpdatePizzaException, SQLException {		
		return pizzaJpa.updatePizza(codePizza, pizza);
	}

	public boolean deletePizza(String codePizza) throws DeletePizzaException, SQLException {
		return pizzaJpa.deletePizza(codePizza);
	}


	public Optional<Pizza> findPizzaByCode(String codePizza) throws SQLException {
	
	    return pizzaJpa.findPizzaByCode(codePizza);
	}
	public boolean isCodeExist(String codePizza) throws SQLException {
		return pizzaJpa.isCodeExist(codePizza);

	}
	
}
