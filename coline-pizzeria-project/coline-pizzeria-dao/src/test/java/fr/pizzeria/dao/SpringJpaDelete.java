package fr.pizzeria.dao;

import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=SpringJpaConfig.class)
public class SpringJpaDelete {
	
	@Autowired @Qualifier("pizzaSpringJpa") PizzaDao jpa;
	@Test
	public void test() throws SQLException {		
		/*Pizza p = new Pizza();
		p.setCat(CategoriePizza.SANS_VIANDE);
		p.setCode("COD");
		p.setNom("Nomdepizza");
		p.setPrix(9.95);
		jpa.saveNewPizza(p);*/
		System.out.println("sauvée");
		jpa.deletePizza("MAR");
		jpa.findAllPizzas().forEach(p -> System.out.println(p.getCode()) );
	}
}
