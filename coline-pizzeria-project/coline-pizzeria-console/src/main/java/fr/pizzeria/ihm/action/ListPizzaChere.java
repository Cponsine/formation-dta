package fr.pizzeria.ihm.action;

import java.sql.SQLException;
import java.util.Comparator;
import java.util.Optional;
import fr.pizzeria.ihm.IhmUtil;
import fr.pizzeria.model.*;

public class ListPizzaChere extends Action{

	private IhmUtil utils;

	public ListPizzaChere(IhmUtil utils) {
		super();
		this.setDescription("6. Afficher pizza la plus chère");
		this.utils = utils;
	}

	@Override
	public void do_action() throws SQLException {
		Comparator triPizza= Comparator.comparing(Pizza::getPrix);
		Optional p= utils.getPizzaDao().findAllPizzas().stream().max(triPizza);
		System.out.println(p);		
		// utils.getPizzaDao().findAllPizzas().stream().reduce( Collections.max(utils.getPizzaDao().findAllPizzas().Prix);

	}
	
	@Override
	public void describe_action() {
		System.out.println(this.getDescription());		
	}

}
