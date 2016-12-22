package fr.pizzeria.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Commande {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private int numCommande;
	private String statut;
	private Date date;	
	
	@ManyToOne
	@JoinColumn(name="livId")
	 Livreur livreur;
	@ManyToOne
	@JoinColumn(name="id_client")
	private Client client;	
	
	@ManyToMany
	@JoinTable(name="commandePizza",joinColumns=
		@JoinColumn(name="id_commande",referencedColumnName="id"), inverseJoinColumns=
		@JoinColumn(name="id_pizza",referencedColumnName="PizzaID"))
	private Set<Pizza> pizzaCommande;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getNumCommande() {
		return numCommande;
	}
	public void setNumCommande(int numCommande) {
		this.numCommande = numCommande;
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Livreur getLivreur() {
		return livreur;
	}
	public void setLivreur(Livreur livreur) {
		this.livreur = livreur;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Set<Pizza> getPizzaCommande() {
		return pizzaCommande;
	}
	public void setPizzaCommande(Set<Pizza> pizzaCommande) {
		this.pizzaCommande = pizzaCommande;
	}
	public Commande() {
		super();
		// TODO Auto-generated constructor stub
	}

}
