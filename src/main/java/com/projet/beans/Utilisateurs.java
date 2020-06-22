package com.projet.beans;

import java.util.Date;
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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.projet.services.Password;


@Entity
@Table(name = "utilisateurs")
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "idUtilisateur")
public class Utilisateurs {
	@Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  @Column(name="idUtilisateur", nullable=false)
	int idUtilisateur;
	
	@Column(name="nom")
	String nom;
	
	@Column(name="username")
	String username ;
	
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
	
	@Column(name="etat")
	boolean etat;
	
	@ManyToMany(cascade = { CascadeType.MERGE },fetch = FetchType.EAGER)
    @JoinTable(
	        name = "roleUser", 
	        joinColumns = { @JoinColumn(name = "idUtilisateur") }, 
	        inverseJoinColumns = { @JoinColumn(name = "idRole") }
	    )
	private Set<Roles> role = new HashSet<>();
	
	
	@OneToMany(mappedBy = "user",fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
	public Set<Locations> loc;
	
	@OneToMany(mappedBy = "user",fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
	public Set<Question> question;
	
	@OneToMany(mappedBy = "user",fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
	public Set<Reponse> reponse;
	
	@OneToMany(mappedBy = "user",fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
	public Set<Redevances> redevance;
	
	
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

	public long getNumNat() {
		return numNat;
	}

	public void setNumNat(long i) {
		this.numNat = i;
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
		Password p = new Password(mdp);
		p.firstHash();
		this.mdp = p.getHash();
	}

	public Set<Roles> getRole() {
		return role;
	}

	public void setRole(Set<Roles> role) {
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	@JsonIgnore
	public Set<Locations> getLoc() {
		return loc;
	}

	public void setLoc(Set<Locations> loc) {
		this.loc = loc;
	}
	@JsonIgnore
	public Set<Question> getQuestion() {
		return question;
	}

	public void setQuestion(Set<Question> question) {
		this.question = question;
	}
	@JsonIgnore
	public Set<Reponse> getReponse() {
		return reponse;
	}

	public void setReponse(Set<Reponse> reponse) {
		this.reponse = reponse;
	}

	public Set<Redevances> getRedevance() {
		return redevance;
	}

	public void setRedevance(Set<Redevances> redevance) {
		this.redevance = redevance;
	}

	public boolean isEtat() {
		return etat;
	}

	public void setEtat(boolean etat) {
		this.etat = etat;
	}
	
	


}
