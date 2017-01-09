package fr.pizzeria.dao;

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
public class SpringJpaAdd {
	
	@Autowired @Qualifier("pizzaSpringJpa") PizzaDao jpa;
	@Test
	public void test() {		
		Pizza p = new Pizza();
		p.setCat(CategoriePizza.SANS_VIANDE);
		p.setCode("COD");
		p.setNom("Nomdepizza");
		p.setPrix(9.95);
		System.out.println("coucoucou");
		jpa.saveNewPizza(p);
		System.out.println("cuicui");
	}
}