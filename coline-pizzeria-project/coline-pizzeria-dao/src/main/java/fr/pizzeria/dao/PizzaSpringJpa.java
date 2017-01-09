package fr.pizzeria.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.pizzeria.Exception.DeletePizzaException;
import fr.pizzeria.Exception.SavePizzaException;
import fr.pizzeria.Exception.UpdatePizzaException;
import fr.pizzeria.model.Pizza;

@Repository
public class PizzaSpringJpa implements PizzaDao {
	@PersistenceContext
	private EntityManager em;
	
	//@Autowired
	//private DataSource dataSource;
	
	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	public PizzaSpringJpa() {
		
	}
	@Transactional
	public List<Pizza> findAllPizzas() throws SQLException {
		TypedQuery<Pizza> q =em.createQuery("select p from Pizza p",Pizza.class);
		return q.getResultList();
	}

	@Transactional
	public boolean saveNewPizza(Pizza pizza) throws SavePizzaException {
		System.out.println("avant");
		em.persist(pizza);
		System.out.println("apres");
		return true;
	}

	@Transactional
	public boolean updatePizza(String codePizza, Pizza pizza) throws UpdatePizzaException, SQLException {
		
		int ind = findAllPizzas().stream().filter(p -> p.getCode().equals(codePizza)).
				findFirst().get().getId();
        Pizza p = em.find(Pizza.class, ind);
        
        if(p != null) {  
            p.setCode(pizza.getCode());
            p.setNom(pizza.getNom());
            p.setPrix(p.getPrix());
            p.setCat(p.getCat());           
        }
		return false;
	}

	@Transactional
	public boolean deletePizza(String codePizza) throws DeletePizzaException, SQLException {
		int ind = findAllPizzas().stream().filter(p -> p.getCode().equals(codePizza)).
				 findFirst().get().getId();
	     Pizza p = em.find(Pizza.class, ind);
	        
	     if(p != null) {	            
	         em.remove(p);
	     }
		return false;
	}
	
	public Optional<Pizza> findPizzaByCode(String codePizza) throws SQLException {
		//String q = "select * from pizza where code=?";
		//template.update(q,codePizza);
		return null;
	}
	
	@Override
	public boolean isCodeExist(String codePizza) throws SQLException {
		
		return false;
	}

}
