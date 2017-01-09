
package fr.pizzeria.dao;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.pizzeria.dao.PizzaSpringJdbc;
import fr.pizzeria.model.Pizza;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=SpringJdbcConfig.class)
public class SpringJdbcList {
	
	@Autowired PizzaSpringJdbc pizzaSpringJdbc;
	
	@Test
	public void test() {
		System.out.println("je suis la ");
		try {
			List<Pizza> t = pizzaSpringJdbc.findAllPizzas();
			System.out.println("taille= "+t.size());
			pizzaSpringJdbc.findAllPizzas().forEach(p -> System.out.println(p.getId()+" - "+p.getNom()));
		} catch (SQLException e) {
			e.printStackTrace();
		}				
	}
}