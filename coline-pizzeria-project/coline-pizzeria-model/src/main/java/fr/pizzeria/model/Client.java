package fr.pizzeria.model;

import javax.persistence.*;

@Entity
public class Client {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	Integer clientID;
	String nom;
	String prenom;
	private String telephone;
	//@Column(name="password")
	//private String mdp;
	/*@OneToMany(mappedBy="client")
	private Set<Commande> commandes;//correct*/
	@Column(name="adresse_rue")
	private String rue;
	@Column(name="adresse_ville")
	private String ville;
	@Column(name="adresse_numero")
	private String numAdresse;
	
	
	public Client() {
		super();		
	}

	public Integer getClientID() {
		return clientID;
	}

	public void setClientID(Integer clientID) {
		this.clientID = clientID;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
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
	}/*
	public Set<Commande> getCommandes() {
		return commandes;
	}
	public void setCommandes(Set<Commande> commandes) {
		this.commandes = commandes;
	}	*/

	/*public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}*/
	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getNumAdresse() {
		return numAdresse;
	}
	public void setNumAdresse(String numAdresse) {
		this.numAdresse = numAdresse;
	}
	
}
