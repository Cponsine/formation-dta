package fr.pizzeria.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import fr.pizzeria.Exception.*;
import fr.pizzeria.model.Pizza;

public interface PizzaDao {

	List<Pizza>	findAllPizzas() throws SQLException;

	boolean saveNewPizza(Pizza pizza) throws SavePizzaException;
	boolean updatePizza(String codePizza, Pizza pizza) throws UpdatePizzaException, SQLException;
	boolean deletePizza(String codePizza) throws DeletePizzaException, SQLException;
	public Optional<Pizza> findPizzaByCode(String codePizza) throws SQLException;
	
	boolean isCodeExist(String codePizza) throws SQLException;
}
