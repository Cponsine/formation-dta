package fr.pizzeria.model;

import java.util.Set;

import javax.persistence.*;

@Entity
public class Livreur {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer livId;

	String nom;
	String prenom;
	
	@OneToMany(mappedBy="livreur")
	Set<Commande> commandesL;
	public Livreur() {
		super();
	}
		
	public int getId() {
		return livId;
	}
	public void setId(int id) {
		this.livId = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

}


