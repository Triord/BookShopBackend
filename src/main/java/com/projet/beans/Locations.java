package com.projet.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;



@Entity
@Table(name = "locations")
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "id")
public class Locations {
	@Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  @Column(name="idLocation", nullable=false)
	int idLocation;
	
	@Column(name="dDebutLocation")
	@Temporal(TemporalType.DATE)
	Date dDebutLocation;
	
	@Column(name="dFinLocation")
	@Temporal(TemporalType.DATE)
	Date dFinLocation;
	
	@Column(name="dateLocation")
	@Temporal(TemporalType.DATE)
	Date dateLocation;
	
	  @ManyToOne(fetch = FetchType.LAZY, optional = false)
	    @JoinColumn(name = "idUtilisateur;", nullable = false)
	    @OnDelete(action = OnDeleteAction.CASCADE)
	private Utilisateurs user;
	  
	  @ManyToOne(fetch = FetchType.LAZY, optional = false)
	    @JoinColumn(name = "idExemplaire;", nullable = false)
	    @OnDelete(action = OnDeleteAction.CASCADE)
	private Exemplaires exemplaire;

	public int getIdLocation() {
		return idLocation;
	}

	public void setIdLocation(int idLocation) {
		this.idLocation = idLocation;
	}

	public Date getdDebutLocation() {
		return dDebutLocation;
	}

	public void setdDebutLocation(Date dDebutLocation) {
		this.dDebutLocation = dDebutLocation;
	}

	public Date getdFinLocation() {
		return dFinLocation;
	}

	public void setdFinLocation(Date dFinLocation) {
		this.dFinLocation = dFinLocation;
	}

	public Date getDateLocation() {
		return dateLocation;
	}

	public void setDateLocation(Date dateLocation) {
		this.dateLocation = dateLocation;
	}

	public Utilisateurs getUser() {
		return user;
	}

	public void setUser(Utilisateurs user) {
		this.user = user;
	}

	public Exemplaires getExemplaire() {
		return exemplaire;
	}

	public void setExemplaire(Exemplaires exemplaire) {
		this.exemplaire = exemplaire;
	}
	
	  

}
