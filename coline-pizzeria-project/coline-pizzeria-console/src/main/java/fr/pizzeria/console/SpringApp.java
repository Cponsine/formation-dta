package fr.pizzeria.console;

import java.sql.SQLException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fr.pizzeria.ihm.MainMenu;

public class SpringApp {
	public static void main(String args[]) throws SQLException {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PizzeriaAppSpringConfig.class);
		MainMenu menu = context.getBean(MainMenu.class);
		menu.start();
	}
}
