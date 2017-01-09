package fr.pizzeria.ihm;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.pizzeria.ihm.action.ListPizza;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=SpringTestConfig.class)
public class ListPizzaTest {
	@Autowired
	private ListPizza lp;
	@Test
	public void test() {
		Assert.assertEquals("1. Lister les pizzas", lp.getDescription());
	}

}
