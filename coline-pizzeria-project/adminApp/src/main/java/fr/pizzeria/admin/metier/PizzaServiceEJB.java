package fr.pizzeria.admin.metier;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

//import fr.pizzeria.dao.PizzaDao;
//import fr.pizzeria.dao.PizzaDaoJpa;
import fr.pizzeria.model.Pizza;

@Stateless
public class PizzaServiceEJB {

	@PersistenceContext(unitName="pizzadb")private EntityManager em;
	
	//private PizzaService pizzaJpa;

//	ResourceBundle bundle = ResourceBundle.getBundle("application");
  //String daoConfig = bundle.getString("dao.impl");

    /*public PizzaServiceEJB() {
		
	
        try {
			pizzaJpa = (PizzaService) Class.forName(daoConfig).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			
			e.printStackTrace();
		}
	}*/
	//@Inject private PizzaDaoJpa pizzaJpa;
	
	public List<Pizza> findAllPizzas()  {
		TypedQuery<Pizza> q =em.createQuery("select p from Pizza p",Pizza.class);
		return q.getResultList();
		
	}
	
	public Pizza saveNewPizza(Pizza pizza) {
		em.persist(pizza);
		return pizza;
	}
	
	public boolean updatePizza(String codePizza, Pizza pizza)  {		
		Pizza current = findPizzaByCode(codePizza);
		current.setCode(pizza.getCode());
		current.setNom(pizza.getNom());
		current.setPrix(pizza.getPrix());
		current.setCat(pizza.getCat());
		return true;
	}


	public boolean deletePizza(String codePizza) {
		Pizza pizza = findPizzaByCode(codePizza);
		em.remove(pizza);
		return true;
	}


	public Pizza findPizzaByCode(String codePizza) {
		TypedQuery<Pizza> q = em.createQuery("SELECT p FROM Pizza p WHERE p.code =:code", Pizza.class);
		q.setParameter("code", codePizza);
		return q.getSingleResult();
	}/*
	public boolean isCodeExist(String codePizza) throws SQLException {
		return pizzaJpa.isCodeExist(codePizza);
	}
	*/

}
