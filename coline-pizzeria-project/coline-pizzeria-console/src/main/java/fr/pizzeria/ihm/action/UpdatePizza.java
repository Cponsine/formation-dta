package fr.pizzeria.ihm.action;

import java.sql.SQLException;
import java.util.Optional;
import java.util.Scanner;

import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.ihm.IhmUtil;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class UpdatePizza extends Action {
//en JDBC cette classe est utilisee pour l'update
	// private IhmUtil utils;
	private Scanner reader;
	private PizzaDao pizzaDao;

	public UpdatePizza(IhmUtil utils) {
		super();
		this.setDescription("3. Mettre � jour une pizza");
		this.reader = utils.getScanner();
		this.pizzaDao = utils.getPizzaDao();
	}

	private void printPizzaList() throws SQLException {

		for (Pizza p: pizzaDao.findAllPizzas()) {
			System.out.println(p.toString());
		}
		System.out.println("Veuillez choisir la pizza � modifier.");
		System.out.println("(99 pour abandonner).");
	}

	@Override
	public void do_action() throws SQLException {

		while (true) {
			printPizzaList();

			String code = reader.next();//System.out.println("j'ai recu le code "+code);
			if (code.equals("99")) 
				break;
			else {
			Optional<Pizza> optPizza = pizzaDao.findPizzaByCode(code);
			if (optPizza.isPresent()) {
				System.out.println("j'ai une pizza");
			
				Pizza pizza = optPizza.get();
				System.out.println("Veuillez saisir le code � updater");
				String newCode = reader.next();
				pizza.setCode(newCode);

				System.out.println("Veuillez saisir le nom (sans espace)");
				String name = reader.next();
				pizza.setNom(name);

				System.out.println("Veuillez saisir le prix");
				String price = reader.next();
				
				try {
					pizza.setPrix(Double.parseDouble(price));
				} catch (Exception e) {
					System.out.println("prix invalide");
				}
				
				System.out.println("Veuillez saisir la cat�gorie");
				String cat = reader.next();
				try {
					pizza.setCat(CategoriePizza.valueOf(cat.toUpperCase()));
				} catch (Exception e) {
					System.out.println("Cat�gorie invalide");
				}
				System.out.println("la pizza: "+pizza.toString());
				this.pizzaDao.updatePizza(code, pizza);
				break;
				
				
			}
			else System.out.println("ta pizza elle est pas la!");
			}
		}
	}

	@Override
	public void describe_action() {
		System.out.println(this.getDescription());
	}

}
