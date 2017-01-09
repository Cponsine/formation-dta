package fr.pizzeria.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import fr.pizzeria.model.Pizza;

@Aspect
@Component
public class SaveAspect {	
	@Before("execution(* fr.pizzeria.dao.PizzaDao.saveNewPizza(..))")
	public void codeInput(JoinPoint point){
		Pizza pizza = (Pizza) point.getArgs()[0];
		pizza.setCode(pizza.getNom().substring(0, 3).toUpperCase());			
	}
	
}
