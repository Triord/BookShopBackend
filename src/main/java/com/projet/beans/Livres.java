package com.projet.beans;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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

	@OneToMany(mappedBy = "livres",orphanRemoval = true,fetch = FetchType.LAZY,cascade = CascadeType.DETACH)	
	private Set<Exemplaires> ex;

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
	
	





}
