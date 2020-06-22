package com.projet.controllers;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.projet.beans.Bibliotheque;
import com.projet.beans.Exemplaires;
import com.projet.beans.Livres;
import com.projet.repositories.BookRepository;
import com.projet.repositories.ExemplaireRepo;
import com.projet.repositories.biblioRepo;
import com.projet.services.BookServiceImpl;
import com.projet.services.ExemplServiceImpl;

@RestController
public class ExemplController {


	@Autowired
	private ExemplaireRepo exRepo;
	@Autowired  
	private ExemplServiceImpl exService;

	@GetMapping("/exemplaire")
	public Set<Exemplaires> allExemplaire(Model model) {
		return exService.allEx();
	}
	
	@PostMapping("/exemplaire")
	public Exemplaires addEx(@RequestBody Exemplaires ex) {
		return exRepo.save(ex);
	}
	@GetMapping("/exemplaire/{id}")
	public Optional<Exemplaires> getEx(@PathVariable int id,Model model) {
		Optional<Exemplaires> ex = exRepo.findById(id);
		
		return ex;
	    			
	}
	@GetMapping("qttLivre/{id}")
	public int getQuantité(@PathVariable int id,Model model){
		
		return exRepo.findqqt(id);
	}
	
	
}
