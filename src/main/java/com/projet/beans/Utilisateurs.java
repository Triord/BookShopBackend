package com.projet.beans;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@Table(name = "utilisateurs")
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "id")
public class Utilisateurs {
	@Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  @Column(name="idUtilisateur", nullable=false)
	int idUtilisateur;
	
	@Column(name="nom")
	String nom;
	
	@Column(name="prenom")
	String prenom;
	
	@Column(name="dDN")
	Date dDN;
	
	@Column(name="numNat")
	String numNat;
	
	@Column(name="email")
	String email;
	
	@Column(name="mdp")
	String mdp;
	
	@ManyToMany(cascade = { CascadeType.MERGE })
    @JoinTable(
	        name = "roleUtilisateur", 
	        joinColumns = { @JoinColumn(name = "idUtilisateur") }, 
	        inverseJoinColumns = { @JoinColumn(name = "idRole") }
	    )
	private Set<Roles> role = new HashSet<>();

	public int getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
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

	public String getNumNat() {
		return numNat;
	}

	public void setNumNat(String numNat) {
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

	public Set<Roles> getRole() {
		return role;
	}

	public void setRole(Set<Roles> role) {
		this.role = role;
	}
	
}
