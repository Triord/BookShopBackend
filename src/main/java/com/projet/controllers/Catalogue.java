package com.projet.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.projet.beans.Bibliotheque;
import com.projet.repositories.biblioRepo;
@RestController
public class Catalogue {

	

	@Autowired
	private biblioRepo bibRep;
	
	@GetMapping("/bibliotheque")
	public List<Bibliotheque> allBiblio(Model model) {
		List<Bibliotheque> biblio = (List<Bibliotheque>) bibRep.allBiblio();
		//model.addAttribute("livree",book);
		return biblio;
	}
	
	@GetMapping("/biblio/{id}")
	public Optional<Bibliotheque> getBiblio(@PathVariable int id,Model model) {
		return bibRep.findById(id);
	}
}
