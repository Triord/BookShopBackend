package com.projet.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.projet.beans.Bibliotheque;
import com.projet.beans.Livres;
import com.projet.beans.Utilisateurs;
import com.projet.repositories.BookRepository;
import com.projet.repositories.UserRepository;
import com.projet.repositories.biblioRepo;
import com.projet.services.BookServiceImpl;
import com.projet.services.UserServiceImpl;
import com.projet.services.biblioService;
import com.projet.services.biblioServiceImpl;

public class ManagementController {

	@Autowired
	private BookRepository bkRep;
	@Autowired
	private BookServiceImpl bkS;
	
	@PostMapping("/Livres")
	public Livres addLivre(@RequestBody Livres livre) {
		return bkRep.save(livre);
	}
	
	@PutMapping("/Livres/{id}")
	public Livres upLivre(@RequestBody Livres livre, @PathVariable long id) {
		return bkS.UpdateBooks(id, livre);
	}
	
	@DeleteMapping("/Livres/{id}")
	public void DelBook(@PathVariable int id) {
	 bkS.DelBook(id);
	}
	
	@Autowired
	private biblioRepo bqRep;
	@Autowired
	private biblioServiceImpl bqS;
	
	@PostMapping("/biblio")
	public Bibliotheque addBiblio(@RequestBody Bibliotheque biblio) {
		return bqRep.save(biblio);
	}
	
	// ADD PUT AND DELETE MAPPING 
	@Autowired
	private UserRepository urRep;
	@Autowired
	private UserServiceImpl urS;
	
	@PutMapping("/user/{id}")
	public Utilisateurs promUser(@RequestBody Utilisateurs user, @PathVariable int id) {
		return urS.promUser(id, user);
	}
	@PutMapping("/bibliothequaire/{id}")
	public Utilisateurs promBiblio(@RequestBody Utilisateurs user, @PathVariable int id) {
		return urS.promBiblio(id, user);
	}
	@PutMapping("/lecteur/{id}")
	public Utilisateurs retroUser(@RequestBody Utilisateurs user, @PathVariable int id) {
		return urS.retroUser(id, user);
	}
	
	
	
}
