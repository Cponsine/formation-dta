package fr.pizzeria.ihm;

import java.util.Scanner;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.dao.PizzaDaoArray;

@Configuration
@ComponentScan({"fr.pizzeria.ihm","fr.pizzeria.ihm.action"})
public class SpringTestConfig {
	@Bean
	public Scanner scanner(){
		return new Scanner(System.in);
	}
	@Bean
	public PizzaDao dao(){
		return new PizzaDaoArray();
	}
	
}
