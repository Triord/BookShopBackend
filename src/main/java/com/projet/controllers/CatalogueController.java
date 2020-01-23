package com.projet.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projet.beans.Bibliotheque;
import com.projet.repositories.biblioRepo;
@RestController
public class CatalogueController {

	

	@Autowired
	private biblioRepo bibRep;
	
	@RequestMapping(value = "/biblio", method = RequestMethod.GET)
	public List<Bibliotheque> allBiblio(Model model) {
		List<Bibliotheque> biblio = (List<Bibliotheque>) bibRep.allBiblio();
		return biblio;
	}
	
	@GetMapping("/biblio/{id}")
	public Optional<Bibliotheque> getBiblio(@PathVariable int id,Model model) {
		return bibRep.findById(id);
	}
}
