package fr.pizzeria.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import fr.pizzeria.Exception.SavePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaDaoArray implements PizzaDao {

	private List<Pizza> pizzas = new ArrayList<>(Arrays.asList(
			new Pizza(0, "PEP", "Peperoni", 12.50,CategoriePizza.VIANDE),
			new Pizza(1, "MAR", "Margherita", 14.00,CategoriePizza.SANS_VIANDE),
			new Pizza(2, "REI", "Reine", 11.50,CategoriePizza.VIANDE),
			new Pizza(3, "FRO", "4 fromages", 12.00,CategoriePizza.SANS_VIANDE),
			new Pizza(4, "CAN", "Cannibale", 12.50,CategoriePizza.VIANDE),
			new Pizza(5, "SAV", "Savoyarde", 13.00,CategoriePizza.SANS_VIANDE),
			new Pizza(6, "ORI", "Orientale", 13.50,CategoriePizza.POISSON),
			new Pizza(7, "IND", "Indienne", 14.00,CategoriePizza.VIANDE)
	));
	
	
	
	@Override
	public List<Pizza> findAllPizzas() {
		return pizzas;
	}

	@Override
	public boolean saveNewPizza(Pizza pizza) throws SavePizzaException {

		pizzas.add(pizza);
		Pizza.nbPizzas++;
		return true;
	}

	@Override
	public boolean updatePizza(String codePizza, Pizza pizza) {
		return false;
	}

	@Override
	public boolean deletePizza(String codePizza) {
		Optional<Pizza> optPizza = findPizzaByCode(codePizza);
		
		optPizza.ifPresent(p -> {
			pizzas.remove(p);
			Pizza.nbPizzas--;
		});
		
		return true;
	}

	public Optional<Pizza> findPizzaByCode(String codePizza) {
		Optional<Pizza> optPizza = pizzas.stream()
			.filter(p -> p.getCode().equals(codePizza))
			.findAny();
		return optPizza;
	}

	@Override
	public boolean isCodeExist(String codePizza) {
		return findPizzaByCode(codePizza).isPresent();
	}
	
}
