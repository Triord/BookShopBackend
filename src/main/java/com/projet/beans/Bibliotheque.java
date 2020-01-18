package com.projet.beans;

import java.io.Serializable;
import java.util.Collection;
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
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "bibliotheques")
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "idBiblio")
public class Bibliotheque{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "idBibliot", nullable=false)
	private int idBiblio;

	@Column(name="nom")
	private String nom;

	@Column(name="adresse")
	private String adresse;

	@Column(name="localisation")
	private String localisation;


	@OneToMany(mappedBy = "bibliotheques",fetch = FetchType.LAZY,cascade = CascadeType.DETACH)
	public Set<Exemplaires> ex;

//	@OneToMany(mappedBy = "bibliotheques",fetch = FetchType.LAZY)
	//public Set<Livres> livre;

	public void setEx(Set<Exemplaires> ex) {
		this.ex = ex;
	}

	public int getIdBiblio() {
		return idBiblio;
	}

	public void setIdBiblio(int idBiblio) {
		this.idBiblio = idBiblio;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getLocalisation() {
		return localisation;
	}

	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}
	//@JsonIgnore
	public Set<Exemplaires> getEx() {
		return ex;
	}

	public void setExemplaires(Set<Exemplaires> ex) {
		this.ex = ex;
	}

	
	
	
	

	/*public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}

	public Set<exemplaires> getEx() {
		return ex;
	}*/

	

	

}
