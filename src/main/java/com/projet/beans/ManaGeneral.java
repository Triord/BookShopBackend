package com.projet.beans;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "manaGeneral")
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "idManaG")
public class ManaGeneral {
	@Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  @Column(name="idManaG", nullable=false)
	int idManaG;
	
	@Column(name="nom")
	String nom;
	
	
	@Column(name="prenom")
	String prenom;
	
	@Column(name="dDN")
	Date dDN;
	
	@Column(name="numNat")
	long numNat;
	
	@Column(name="email")
	String email;
	
	@Column(name="mdp")
	String mdp;
	
	@OneToMany(mappedBy = "manaG",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	public Set<Bibliotheque> bib;

	public int getIdManaG() {
		return idManaG;
	}

	public void setIdManaG(int idManaG) {
		this.idManaG = idManaG;
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

	public Date getdDN() {
		return dDN;
	}

	public void setdDN(Date dDN) {
		this.dDN = dDN;
	}

	public long getNumNat() {
		return numNat;
	}

	public void setNumNat(long numNat) {
		this.numNat = numNat;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public Set<Bibliotheque> getBib() {
		return bib;
	}

	public void setBib(Set<Bibliotheque> bib) {
		this.bib = bib;
	}
	
	
}
