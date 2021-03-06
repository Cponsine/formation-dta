package fr.pizzeria.ihm.action;

import java.sql.SQLException;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import fr.pizzeria.ihm.IhmUtil;
import fr.pizzeria.model.Pizza;
@Component
public class ListPizza extends Action {

	@PostConstruct		
	public void init(){
		this.setDescription("1. Lister les pizzas");
	}

	public ListPizza() {
		super();
	}

	private IhmUtil utils;

	public ListPizza(IhmUtil utils) {
		super();
		this.setDescription("1. Lister les pizzas");
		this.utils = utils;
	}

	@Override
	public void do_action() throws SQLException {

		for (Pizza p: utils.getPizzaDao().findAllPizzas()) {
			System.out.println(p.toString());
		}
		System.out.println(utils.getPizzaDao().findAllPizzas().size() + " pizzas");
	}
	
	@Override
	public void describe_action() {
		System.out.println(this.getDescription());
	}

}
