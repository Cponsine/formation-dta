package fr.pizzeria.aspect;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=AspectConfig.class)
public class PizzaCodeTest {
	
	@Autowired @Qualifier("pizzaSpringJdbc") PizzaDao pi;
	@Test
	public void test() {	
		Pizza p = new Pizza();
		p.setCat(CategoriePizza.SANS_VIANDE);
		//p.setCode("COD");
		p.setNom("Nomdepizza");
		p.setPrix(9.95);
		System.out.println(p.toString());
		pi.saveNewPizza(p);
		
	}

}
