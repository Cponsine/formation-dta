package fr.pizzeria.console;

import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;

import javax.print.attribute.standard.PrinterLocation;
import javax.swing.plaf.synth.SynthSpinnerUI;

import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.dao.PizzaDaoArray;
import fr.pizzeria.ihm.IhmUtil;
import fr.pizzeria.ihm.MainMenu;
import fr.pizzeria.model.Pizza;

public class PizzeriaAdminConsoleApp {
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException  {
		java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
		ResourceBundle bundle = ResourceBundle.getBundle("application");
		String daoConfig = bundle.getString("dao.impl");
		PizzaDao daoFactory = (PizzaDao) Class.forName(daoConfig).newInstance();

		IhmUtil utils = new IhmUtil(new Scanner(System.in), daoFactory);
		MainMenu core = new MainMenu(utils);

		core.start();
	}
}
