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
@Table(name = "amendes")
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "id")
public class Amendes {
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  @Column(name="idAmende", nullable=false)
	int idAmende ;
	  
	  @Column(name="dateAmende")
	  @Temporal(TemporalType.DATE)
	Date dateAmende;
	  
	  @Column(name="delaiDepassement")
	int delaiDepassement;
	  
	  @Column(name="montant")
	float montant;

	    @ManyToOne(fetch = FetchType.LAZY, optional = false)
	    @JoinColumn(name = "idUtilisateur;", nullable = false)
	    @OnDelete(action = OnDeleteAction.CASCADE)
	private Utilisateurs user;

		public int getIdAmende() {
			return idAmende;
		}

		public void setIdAmende(int idAmende) {
			this.idAmende = idAmende;
		}

		public Date getDateAmende() {
			return dateAmende;
		}

		public void setDateAmende(Date dateAmende) {
			this.dateAmende = dateAmende;
		}

		public int getDelaiDepassement() {
			return delaiDepassement;
		}

		public void setDelaiDepassement(int delaiDepassement) {
			this.delaiDepassement = delaiDepassement;
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
