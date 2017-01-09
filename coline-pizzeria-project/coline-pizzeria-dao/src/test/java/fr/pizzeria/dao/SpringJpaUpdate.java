package fr.pizzeria.dao;

import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=SpringJpaConfig.class)
public class SpringJpaUpdate {
	
	@Autowired @Qualifier("pizzaSpringJpa") PizzaDao jpa;
	@Test
	public void test() throws SQLException {		
		/*Pizza p = new Pizza();
		p.setCat(CategoriePizza.SANS_VIANDE);
		p.setCode("COD");
		p.setNom("Nomdepizza");
		p.setPrix(9.95);
		jpa.saveNewPizza(p);
		System.out.println("sauvée");*/
		Pizza q = new Pizza();
		q.setCat(CategoriePizza.POISSON);
		q.setCode("HIN");
		q.setNom("Hindou");
		q.setPrix(8.75);
		System.out.println("----");
		jpa.updatePizza("IND", q);
		jpa.findAllPizzas().forEach(g -> System.out.println(g.getNom()));
	}
}
