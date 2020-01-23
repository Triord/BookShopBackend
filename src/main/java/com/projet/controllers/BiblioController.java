package com.projet.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
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
public class BiblioController {

	@Autowired
	private biblioRepo bibRep;

	@PostMapping("/biblio")
	public Bibliotheque addBiblio(@RequestBody Bibliotheque biblio) {
		return bibRep.save(biblio);
	}
	

}
