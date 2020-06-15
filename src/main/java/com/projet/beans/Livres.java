package com.projet.beans;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.projet.exceptions.ProduitIntrouvableException;



@Entity
@Table(name = "livre")
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "idlivre")
public class Livres {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idlivre", nullable=false)
	int idlivre;

	@Column(name="nom")
	String nom;

	@Column(name="isbn")
	String isbn;

	@Column(name="descriptif")
	String descriptif;

	@Column(name="prix")
	float prix;

	@Column(name="edition")
	String edition;
	
	@Column(name="etat")
	Boolean etat;
	
	@Column(name="images")
	String images;

	@OneToMany(mappedBy = "livres",fetch = FetchType.LAZY,cascade = CascadeType.ALL)	
	private Set<Exemplaires> ex;


	


	@OneToMany(mappedBy = "livre",fetch = FetchType.LAZY,cascade = CascadeType.MERGE)	
	private Set<Critiques> crit;

	@ManyToMany(mappedBy = "book")
	private Set<Locations> location = new HashSet<>();
	
	@ManyToMany(mappedBy = "book")
	private Set<Locations> livre = new HashSet<>();

	@JsonIgnore
	public Set<Locations> getLocation() {
		return location;
	}

	public void setLocation(Set<Locations> location) {
		this.location = location;
	}

	public int getIdlivre() {
		return idlivre;
	}

	public void setIdlivre(int idlivre) {
		this.idlivre = idlivre;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getDescriptif() {
		return descriptif;
	}

	public void setDescriptif(String descriptif) {
		this.descriptif = descriptif;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}
	@JsonIgnore
	public Set<Exemplaires> getEx() {
		return ex;
	}

	public void setEx(Set<Exemplaires> ex) {
		this.ex = ex;
	}

	public Set<Critiques> getCrit() {
		return crit;
	}

	public void setCrit(Set<Critiques> crit) {
		this.crit = crit;
	}

	public Boolean getEtat() {
		return etat;
	}

	public void setEtat(Boolean etat) {
		this.etat = etat;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public Set<Locations> getLivre() {
		return livre;
	}

	public void setLivre(Set<Locations> livre) {
		this.livre = livre;
	}


	


	
	
}
