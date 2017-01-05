package fr.pizzeria.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import fr.pizzeria.Exception.DeletePizzaException;
import fr.pizzeria.Exception.SavePizzaException;
import fr.pizzeria.Exception.UpdatePizzaException;
import fr.pizzeria.model.Pizza;

public class PizzaDaoRest implements PizzaDao{
	Client client = ClientBuilder.newClient();
	WebTarget target=client.target("http://localhost:8080/adminApp/api/rest/pizzas");

	
	@Override
	public List<Pizza> findAllPizzas() {
		// TODO Auto-generated method stub
		List<Pizza> list = target.request().get(new GenericType<List<Pizza>>(){});
		return list;
	}

	@Override
	public boolean saveNewPizza(Pizza pizza) throws SavePizzaException {
		target.request().post(Entity.entity(pizza, MediaType.APPLICATION_JSON),Pizza.class);
		return false;
	}

	@Override
	public boolean updatePizza(String codePizza, Pizza pizza) throws UpdatePizzaException, SQLException {
		target.path(codePizza).request().put(Entity.entity(pizza, MediaType.APPLICATION_JSON),Pizza.class);
		
		return false;
	}

	@Override
	public boolean deletePizza(String codePizza) throws DeletePizzaException, SQLException {
		target.path(codePizza).request().delete();
		return false;
	}

	@Override
	public boolean isCodeExist(String codePizza) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Optional<Pizza> findPizzaByCode(String codePizza) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
