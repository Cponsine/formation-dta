package fr.pizzeria.model;

import javax.persistence.*;

@Entity
public class Pizza {

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PizzaID")
	private Integer id;
//pas besoin de renommer
	private String code;
	@Column(name="libelle")
	private String nom;
	private double prix;
	@Enumerated(EnumType.STRING)
	@Column(name="categorie")
	private CategoriePizza cat;
	@Transient
	public static int nbPizzas;


	public Pizza() {
		super();
	}

	public Pizza(Integer id, String code, String nom, double prix,CategoriePizza cat) {
		super();
		this.id = id;
		this.code = code;
		this.nom = nom;
		this.prix = prix;
		this.cat = cat;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public static int getNbPizzas() {
		return nbPizzas;
	}

	public static void setNbPizzas(int nbPizzas) {
		Pizza.nbPizzas = nbPizzas;
	}

	public CategoriePizza getCat() {
		return cat;
	}

	public void setCat(CategoriePizza cat) {
		this.cat = cat;
	}

	public String toString() {
		
		return this.getCode() + "-> " + this.getNom() + " (" + this.getPrix() + " � - " + cat.getValue() + ")";
		
	}

	
	
}
