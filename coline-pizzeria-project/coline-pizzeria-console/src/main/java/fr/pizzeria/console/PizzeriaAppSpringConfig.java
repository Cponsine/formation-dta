package fr.pizzeria.console;

import java.util.Scanner;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.dao.PizzaDaoArray;
import fr.pizzeria.dao.PizzaDaoJdbc;
import fr.pizzeria.dao.PizzaDaoJpa;

@Configuration
@ComponentScan("fr.pizzeria.ihm")
public class PizzeriaAppSpringConfig  {
	@Bean
	public Scanner scanner(){
		return new Scanner(System.in);
	}
	@Bean
	public PizzaDao dao(){
		return new PizzaDaoArray();
	}
}
