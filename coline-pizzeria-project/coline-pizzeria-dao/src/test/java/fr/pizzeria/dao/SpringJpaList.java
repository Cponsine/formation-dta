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
public class SpringJpaList {
	
	@Autowired @Qualifier("pizzaSpringJpa") PizzaDao jpa;
	@Test
	public void test() throws SQLException {		
		System.out.println(jpa.findAllPizzas().size());//jpa.findAllPizzas().forEach(p -> System.out.println(p.getNom()));	
		Pizza p = new Pizza();
		p.setCat(CategoriePizza.SANS_VIANDE);
		p.setCode("COD");
		p.setNom("Nomdepizza");
		p.setPrix(9.95);
		//jpa.saveNewPizza(p);
		System.out.println("coucou");
		/*p=new Pizza();
		p.setCat(CategoriePizza.VIANDE);
		p.setCode("AUT");
		p.setNom("Autrepizza");
		p.setPrix(8.95);
		*/
		System.out.println("cuicui");
		jpa.findAllPizzas().forEach(q -> System.out.println(q.getCode() + q.getNom()));
	}
}
