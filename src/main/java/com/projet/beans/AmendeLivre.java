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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "amendeLivre")
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "id")
public class AmendeLivre {
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  @Column(name="id", nullable=false)
	int id ;
	  
	  @Column(name="dateDue")
	  @Temporal(TemporalType.DATE)
	Date dateDue;
	  
	  @Column(name="dateRetour")
	  @Temporal(TemporalType.DATE)
	Date dateRetour;
	  

		@ManyToOne (fetch=FetchType.LAZY)
		@JoinColumn(name="idUtilisateur", insertable=false, updatable=false)
		private Utilisateurs user;
		
		@OneToOne (fetch=FetchType.LAZY)
		@JoinColumn(name="idLivre")
		private Livres book;
}
