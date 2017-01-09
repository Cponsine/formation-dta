package fr.pizzeria.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import fr.pizzeria.Exception.DeletePizzaException;
import fr.pizzeria.Exception.SavePizzaException;
import fr.pizzeria.Exception.UpdatePizzaException;
import fr.pizzeria.model.Pizza;

public class PizzaDaoJpa implements PizzaDao{
	EntityManagerFactory emf;
	EntityManager em;

	public PizzaDaoJpa() {
		super();
		emf = Persistence.createEntityManagerFactory("pizzeria-console");
		em = emf.createEntityManager();
	}

	@Override
	public List<Pizza> findAllPizzas() throws SQLException {		
		TypedQuery<Pizza> q =em.createQuery("select p from Pizza p",Pizza.class);
		return q.getResultList();
	}

	@Override
	public boolean saveNewPizza(Pizza pizza) throws SavePizzaException {
		em.getTransaction().begin();
		em.persist(pizza);
		em.getTransaction().commit();
		return true;
	}

	@Override
	public boolean updatePizza(String codePizza, Pizza pizza) throws UpdatePizzaException, SQLException {
		EntityTransaction t= em.getTransaction();
		t.begin();
		int ind = findAllPizzas().stream().filter(p -> p.getCode().equals(codePizza)).
				findFirst().get().getId();
        Pizza p = em.find(Pizza.class, ind);
        
        if(p != null) {  
            p.setCode(pizza.getCode());
            p.setNom(pizza.getNom());
            p.setPrix(p.getPrix());
            p.setCat(p.getCat());           
        }
        
        t.commit();
		
		return false;
	}

	@Override
	public boolean deletePizza(String codePizza) throws DeletePizzaException, SQLException {
		EntityTransaction t=em.getTransaction();
		t.begin();
		 int ind = findAllPizzas().stream().filter(p -> p.getCode().equals(codePizza)).
				 findFirst().get().getId();
	     Pizza p = em.find(Pizza.class, ind);
	        
	     if(p != null) {	            
	         em.remove(p);
	     }
	     t.commit();
	     return false;
	}

	@Override
	public Optional<Pizza> findPizzaByCode(String codePizza) throws SQLException {
		Optional<Pizza> optPizza = findAllPizzas().stream()
	            .filter(p -> p.getCode().equals(codePizza))
	            .findAny();
	    return optPizza;
	}

	@Override
	public boolean isCodeExist(String codePizza) throws SQLException {
		return findPizzaByCode(codePizza).isPresent();

	}

}
