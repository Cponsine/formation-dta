package fr.pizzeria.ihm;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import fr.pizzeria.dao.PizzaDao;
@Component
public class IhmUtil {
	@Autowired
	private Scanner scanner;
	@Autowired
	@Qualifier("dao")
	private PizzaDao pizzaDao;

	public IhmUtil() {
		super();
		// TODO Auto-generated constructor stub
	}

	public IhmUtil(Scanner scanner, PizzaDao pizzaDao) {

		this.scanner = scanner;
		this.pizzaDao = pizzaDao;
	}

	public Scanner getScanner() {
		return scanner;
	}

	public void setScanner(Scanner scanner) {
		this.scanner = scanner;
	}

	public PizzaDao getPizzaDao() {
		return pizzaDao;
	}

	public void setPizzaDao(PizzaDao pizzaDao) {
		this.pizzaDao = pizzaDao;
	}
}
