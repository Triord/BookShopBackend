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
@Table(name = "redevances")
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "id")
public class Redevances {
	@Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  @Column(name="idRedevance", nullable=false)
	int idRedevance ;
	
	@Column(name="datePaiementRedevance")
	@Temporal(TemporalType.DATE)
	Date datePaiementRedevance;
	
	@Column(name="dateFinRedevance")
	@Temporal(TemporalType.DATE)
	Date dateFinRedevance ;
	
	@Column(name="montant")
	float montant;
	
	  @ManyToOne(fetch = FetchType.LAZY, optional = false)
	    @JoinColumn(name = "idUtilisateur;", nullable = false)
	    @OnDelete(action = OnDeleteAction.CASCADE)
	private Utilisateurs user;

	public int getIdRedevance() {
		return idRedevance;
	}

	public void setIdRedevance(int idRedevance) {
		this.idRedevance = idRedevance;
	}

	public Date getDatePaiementRedevance() {
		return datePaiementRedevance;
	}

	public void setDatePaiementRedevance(Date datePaiementRedevance) {
		this.datePaiementRedevance = datePaiementRedevance;
	}

	public Date getDateFinRedevance() {
		return dateFinRedevance;
	}

	public void setDateFinRedevance(Date dateFinRedevance) {
		this.dateFinRedevance = dateFinRedevance;
	}

	public float getMontant() {
		return montant;
	}

	public void setMontant(float montant) {
		this.montant = montant;
	}

	public Utilisateurs getUser() {
		return user;
	}

	public void setUser(Utilisateurs user) {
		this.user = user;
	}
	  
	
}
