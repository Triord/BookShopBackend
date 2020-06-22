package com.projet.beans;

import javax.persistence.CascadeType;
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
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "critiques")
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "idCritique")
public class Critiques {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idCritique", nullable=false)
	int idCritique;

	@Column(name="commentaires")
	String commentaires;

	@Column(name="notes")
	int notes;

	@ManyToOne(cascade = { CascadeType.MERGE })
	@JoinColumn(name = "idlivre", nullable = false)
	private Livres livre;

	public int getIdCritique() {
		return idCritique;
	}

	public void setIdCritique(int idCritique) {
		this.idCritique = idCritique;
	}

	public String getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(String commentaires) {
		this.commentaires = commentaires;
	}

	public int getNotes() {
		return notes;
	}

	public void setNotes(int notes) {
		this.notes = notes;
	}
	@JsonIgnore
	public Livres getLivre() {
		return livre;
	}

	public void setLivre(Livres livre) {
		this.livre = livre;
	}

}
