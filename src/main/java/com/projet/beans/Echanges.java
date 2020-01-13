package com.projet.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "echanges")
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "id")
public class Echanges {
	@Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  @Column(name="idEchange", nullable=false)
	int idEchange ;
	
	  @Column(name="question")
	String question;
	  
	  @Column(name="reponse")
	String reponse;
	  
	  @ManyToOne(fetch = FetchType.LAZY, optional = false)
	    @JoinColumn(name = "idUtilisateur;", nullable = false)
	    @OnDelete(action = OnDeleteAction.CASCADE)
	private Utilisateurs user;

	public int getIdEchange() {
		return idEchange;
	}

	public void setIdEchange(int idEchange) {
		this.idEchange = idEchange;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getReponse() {
		return reponse;
	}

	public void setReponse(String reponse) {
		this.reponse = reponse;
	}

	public Utilisateurs getUser() {
		return user;
	}

	public void setUser(Utilisateurs user) {
		this.user = user;
	}
	  
	
}
