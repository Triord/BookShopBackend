package com.projet.beans;

import java.beans.Transient;
import java.util.*;

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
		property = "idExemplaire")
public class Exemplaires {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idExemplaire", nullable=false)
	int idExemplaire;

	@Column(name="etat")
	int etat;

	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "idlivre", nullable = false)
	private Livres livres;

	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "idBibliot", nullable = false)
	private Bibliotheque bibliotheques;

	public int getIdExemplaire() {
		return idExemplaire;
	}

	public void setIdExemplaire(int idExemplaire) {
		this.idExemplaire = idExemplaire;
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

	public Bibliotheque getBibliotheques() {
		return bibliotheques;
	}

	public void setBibliotheques(Bibliotheque bibliotheques) {
		this.bibliotheques = bibliotheques;
	}


	






}
