package com.projet.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.projet.beans.Bibliotheque;
import com.projet.beans.Exemplaires;
import com.projet.beans.Livres;
import com.projet.repositories.BookRepository;
import com.projet.repositories.ExemplaireRepo;
import com.projet.repositories.biblioRepo;
import com.projet.services.BookServiceImpl;

@RestController
public class LivreController {

	@Autowired
	private BookRepository livreRep;
	@Autowired
	private BookServiceImpl Livreserv ;


	@GetMapping("/Livres")
	public List<Livres> allLivre(Model model) {
		List<Livres> Livres = (List<Livres>) livreRep.findAll();
		//model.addAttribute("livree",book);
		return Livres;
	}

	@PostMapping("/Livres")
	public Livres addLivre(@RequestBody Livres livre) {
		return livreRep.save(livre);
	}

	@PutMapping("/Livres/{id}")
	public Livres upLivre(@RequestBody Livres livre, @PathVariable long id) {
		return Livreserv.UpdateBooks(id, livre);
	}
	@GetMapping("/Livres/{id}")
	public Optional<Livres> getBook(@PathVariable int id,Model model) {
		Optional<Livres> livre = livreRep.findById(id);
		
		return livre;
	    	
		
		//service.notSubscribed();

		
	}



}
