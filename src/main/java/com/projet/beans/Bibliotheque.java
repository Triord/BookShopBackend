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

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

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
		property = "idBibliot")
public class Bibliotheque{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "idBibliot", nullable=false)
	private int idBibliot;

	@Column(name="nom")
	private String nom;

	@Column(name="adresse")
	private String adresse;

	@Column(name="localisation")
	private String localisation;


	@OneToMany(mappedBy = "bibliotheques",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	public Set<Exemplaires> ex;
	
	@ManyToOne(cascade = { CascadeType.MERGE },fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumn(name = "idManaG")
	private ManaGeneral manaG;

	public int getIdBibliot() {
		return idBibliot;
	}

	public void setIdBibliot(int idBibliot) {
		this.idBibliot = idBibliot;
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
	@JsonIgnore
	public Set<Exemplaires> getEx() {
		return ex;
	}

	public void setExemplaires(Set<Exemplaires> ex) {
		this.ex = ex;
	}

	public ManaGeneral getManaG() {
		return manaG;
	}

	public void setManaG(ManaGeneral manaG) {
		this.manaG = manaG;
	}

	public void setEx(Set<Exemplaires> ex) {
		this.ex = ex;
	}
	
	
}
