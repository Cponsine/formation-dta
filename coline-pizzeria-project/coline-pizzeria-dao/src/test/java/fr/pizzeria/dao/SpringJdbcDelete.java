package fr.pizzeria.dao;

import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=SpringJdbcConfig.class)
public class SpringJdbcDelete {
	
	@Autowired PizzaSpringJdbc pizzaSpringJdbc;
	@Test
	public void test() throws SQLException {		
		pizzaSpringJdbc.deletePizza("COD");			
	}
}
