package com.projet.beans;

import java.util.HashSet;
import java.util.*;

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

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "exemplaires")
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "id")
public class Exemplaires {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idexemplaire", nullable=false)
	int id;

	@Column(name="etat")
	int etat;

	@ManyToOne
	@JoinColumn(name = "idlivre", nullable = false)
	private Livres livres;

	@ManyToOne
	@JoinColumn(name = "idBibliot", nullable = false)
	private Bibliotheque bibliotheques;




	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEtat() {
		return etat;
	}

	public void setEtat(int etat) {
		this.etat = etat;
	}


	public Livres getLivres() {
		return livres;
	}

	public void setLivres(Livres livres) {
		this.livres = livres;
	}
	//@JsonIgnore
	public Bibliotheque getBibliotheques() {
		return bibliotheques;
	}

	public void setBibliotheques(Bibliotheque bibliotheques) {
		this.bibliotheques = bibliotheques;
	}







}
