package fr.pizzeria.ihm.action;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import fr.pizzeria.dao.*;
import fr.pizzeria.ihm.IhmUtil;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.model.CategoriePizza;
public class ListPizzaChere extends Action{

	private IhmUtil utils;

	public ListPizzaChere(IhmUtil utils) {
		super();
		this.setDescription("6. Imprimer la pizza la plus chère ");
		this.utils = utils;
	}

	@Override
	public void do_action() {

		
		Comparator<Pizza> triPizza= Comparator.comparing(Pizza::getPrix);
		Pizza p= utils.getPizzaDao().findAllPizzas().stream().max(triPizza));

		System.out.println(p);
	}
	
	@Override
	public void describe_action() {
		System.out.println(this.getDescription());
		
	}

}
