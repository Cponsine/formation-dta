package fr.pizzeria.console;

import java.sql.SQLException;
import java.util.logging.Level;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import fr.pizzeria.ihm.MainMenu;

public class PizzeriaAdminConsoleApp {
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException  {
		java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
		//ResourceBundle bundle = ResourceBundle.getBundle("application");
		//String daoConfig = bundle.getString("dao.impl");
		//PizzaDao daoFactory = (PizzaDao) Class.forName(daoConfig).newInstance();
		ApplicationContext context = new FileSystemXmlApplicationContext("C:/Users/ETY4/Documents/Java/formation-dta/coline-pizzeria-project/coline-pizzeria-console/src/main/resources/application-confi.xml");
		//Scanner s = (Scanner) context.getBean("scanner");
		//IhmUtil utils=(IhmUtil) context.getBean("ihm");
		MainMenu core = (MainMenu) context.getBean("menu");
		//PizzaDaoRest dao = new PizzaDaoRest();
		core.start();
		//core.displayMenu();
		}
}
