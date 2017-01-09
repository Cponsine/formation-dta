package fr.pizzeria.dao;

import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=SpringJdbcConfig.class)
public class SpringJdbcUpdate {
	
	@Autowired PizzaSpringJdbc pizzaSpringJdbc;
	@Test
	public void test() throws SQLException {		
		Pizza p = new Pizza();
		p.setCat(CategoriePizza.POISSON);
		p.setCode("SUD");
		p.setNom("Grattouille");
		p.setPrix(8.75);

		pizzaSpringJdbc.updatePizza("REG", p);			
	}
}
