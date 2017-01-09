package fr.pizzeria.admin.metier;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import fr.pizzeria.model.Client;

@Stateless
public class ClientServiceEJB {
	@PersistenceContext(unitName="pizzadb")
	private EntityManager em;
	
	public ClientServiceEJB() {
	super();
}

	public List<Client> findAllClients()  {
		TypedQuery<Client> q =em.createQuery("select c from Client c",Client.class);
		return q.getResultList();
		
	}
	
	public void saveNewClient(Client c) {
		
		em.persist(c);
		//return c;
	}
	
	public boolean updateClient(int code, Client c)  {		
		Client current = findClientByID(code);
		current.setNom(c.getNom());
		current.setPrenom(c.getPrenom());
		current.setRue(c.getRue());
		current.setVille(c.getVille());
		current.setTelephone(c.getTelephone());
		current.setNumAdresse(c.getNumAdresse());
		return true;
	}


	public boolean deleteClient(int clid) {
		Client c = findClientByID(clid);
		em.remove(c);
		return true;
	}

	public Client findClientByID(int id) {
		TypedQuery<Client> q = em.createQuery("SELECT c FROM Client c WHERE c.clientID =:code", Client.class);
		q.setParameter("code", id);
		return q.getSingleResult();
	}
	/*
	public boolean isCodeExist(String codePizza) throws SQLException {
		return pizzaJpa.isCodeExist(codePizza);
	}
	*/
}
