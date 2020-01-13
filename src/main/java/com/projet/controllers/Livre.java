package com.projet.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.projet.beans.Bibliotheque;
import com.projet.beans.Exemplaires;
import com.projet.beans.Livres;
import com.projet.repositories.BookRepository;
import com.projet.repositories.ExemplaireRepo;
import com.projet.repositories.biblioRepo;
import com.projet.services.BookServiceImpl;

@RestController
public class Livre {

	@Autowired
	private BookRepository livreRep;
	@Autowired
	private BookServiceImpl Livreserv ;
	@Autowired
	private ExemplaireRepo exRepo;
	@Autowired
	private biblioRepo bibRep;
	/*@GetMapping("/allBook")
	public List<Livres> livreInfo(Model model) {
		List<Livres> l = (List<Livres>) livreRep.findAll();
		model.addAttribute("allBook",l);
		return l;
		
		
	}
	@GetMapping("/test")
	public List<Livres> test(Model model){
		Livreserv.getSetLivres();
		List<Livres> l = (List<Livres>) livreRep.findAll();
		return l;
		
	}
	@GetMapping("/test2")
	 public List<Exemplaires> getAllBook() {
		 
		        return (List<Exemplaires>) livreRep.findAll();
		    
    }*/
	@GetMapping("/Livres")
	public List<Livres> allLivre(Model model) {
		List<Livres> Livres = (List<Livres>) livreRep.findAll();
		//model.addAttribute("livree",book);
		return Livres;
		}
	
	@GetMapping("/exemplaire")
	public List<Exemplaires> allExemplaire(Model model) {
		List<Exemplaires> ex = (List<Exemplaires>) exRepo.findAll();
		//model.addAttribute("livree",book);
		return ex;
		}
	@GetMapping("/biblio")
	public List<Bibliotheque> allBiblio(Model model) {
		List<Bibliotheque> biblio = (List<Bibliotheque>) bibRep.findAll();
		//model.addAttribute("livree",book);
		return biblio;
		}
	
	  @GetMapping("/Exemplaires/{id}")
	    public Optional<Exemplaires> getBookModel(@PathVariable int id,Model model) {
	    	Optional<Exemplaires> ex = exRepo.findById(id);
	    	//service.notSubscribed();
	    	
	        return ex;
	    }
	
}
