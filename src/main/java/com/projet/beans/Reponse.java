package com.projet.beans;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "reponse")
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "idReponse")
public class Reponse {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idReponse", nullable=false)
	int idReponse;

	@Column(name="dateReponse")
	@Temporal(TemporalType.DATE)
	Date dateQuestion;

	@Column(name="contenu")
	String contenu;

	@ManyToOne(cascade = { CascadeType.MERGE })
	@JoinColumn(name = "idAdmin",nullable = false)
	private Utilisateurs user;

	@ManyToOne(cascade = { CascadeType.MERGE })
	@JoinColumn(name = "idQuestion",nullable = false)
	private Question question;

	public int getIdReponse() {
		return idReponse;
	}

	public void setIdReponse(int idReponse) {
		this.idReponse = idReponse;
	}

	public Date getDateQuestion() {
		return dateQuestion;
	}

	public void setDateQuestion(Date dateQuestion) {
		this.dateQuestion = dateQuestion;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public Utilisateurs getUser() {
		return user;
	}

	public void setUser(Utilisateurs user) {
		this.user = user;
	}
	//@JsonIgnore
	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}




}
