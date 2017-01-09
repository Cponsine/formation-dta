package fr.pizzeria.ihm;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.pizzeria.ihm.action.*;

@Component
public class MainMenu {

	//Action[] menu = new Action[5];
	@Autowired
	IhmUtil utils;
	
	public MainMenu() {
		super();
	}

	Map<Integer, Action> menu = new HashMap<>();
	
	@PostConstruct		
	public void init(){
		this.menu.put(0, new ListPizza(utils));
		this.menu.put(1, new AddPizza(utils));		
		this.menu.put(2, new UpdatePizza(utils));
		this.menu.put(3, new DeletePizza(utils)); 
		this.menu.put(4, new ListPizzaGpCat(utils));
		this.menu.put(5, new ListPizzaChere(utils));
		this.menu.put(6, new ExitMenu());		
	}
	
	public MainMenu(IhmUtil utils) {

		this.menu.put(0, new ListPizza(utils));
		this.menu.put(1, new AddPizza(utils));
		
		this.menu.put(2, new UpdatePizza(utils));
		this.menu.put(3, new DeletePizza(utils)); 
		this.menu.put(4, new ListPizzaGpCat(utils));
		this.menu.put(5, new ListPizzaChere(utils));
		this.menu.put(6, new ExitMenu());

		this.utils = utils;
	}

	public void displayMenu() {

		System.out.println("\n ***** Pizzeria Administration *****");
		
		menu.forEach((key, value) -> {
			value.describe_action();
		});
				
				
				//i) -> describe_action();
		
		//for (int i = 0; i < this.menu.length; ++i) {
		//	this.menu[i].describe_action();
		}
	

	private boolean parseAndExec() throws SQLException {

		String input = utils.getScanner().next();

		if (Integer.parseInt(input) < menu.size()) {
			this.menu.get(Integer.parseInt(input) - 1).do_action();
			return true;
		}
		else if (Integer.parseInt(input) == 99)
			this.menu.get(6).do_action();
		return false;
	}

	public void start() throws SQLException{

		do {
			this.displayMenu();
		} while (this.parseAndExec());
	}
}