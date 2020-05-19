package com.projet.controllers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.time.*;
import com.projet.beans.Amendes;
import com.projet.beans.Bibliotheque;
import com.projet.beans.Critiques;
import com.projet.beans.Exemplaires;
import com.projet.beans.Livres;
import com.projet.beans.Locations;
import com.projet.beans.Question;
import com.projet.beans.Redevances;
import com.projet.beans.Roles;
import com.projet.beans.Utilisateurs;
import com.projet.exception.LocationException;
import com.projet.exceptions.ProduitIntrouvableException;
import com.projet.repositories.AmendeRepo;
import com.projet.repositories.BookRepository;
import com.projet.repositories.CritiqueRepository;
import com.projet.repositories.LocRepository;
import com.projet.repositories.RedevanceRepo;
import com.projet.repositories.RoleRepository;
import com.projet.repositories.UserRepository;
import com.projet.services.BookServiceImpl;
import com.projet.services.LocationService;
import com.projet.services.LocationServiceImpl;
import com.projet.services.Password;
import com.projet.services.ServiceRequest;
import com.projet.services.UserServiceImpl;

@RestController
public class UserController {

	@Autowired
	private UserServiceImpl userServ;
	@Autowired
	private BookServiceImpl bkS;
	@Autowired
	private BookRepository bkR;
	@Autowired 
	private AmendeRepo aRep;
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private RoleRepository roleRepo;
	@Autowired
	private LocationServiceImpl locS;
	@Autowired
	private LocRepository locRep;
	@Autowired
	private CritiqueRepository critRep;

	@PostMapping("/user")
	public ServiceRequest addUser(@RequestBody Utilisateurs user) {

		return userServ.addUser(user);
	}

	@GetMapping("/user/{id}")
	public Utilisateurs getUser(@PathVariable int id,Model model) {
		Utilisateurs user = userServ.getUser(id);

		return user;
	}
	@DeleteMapping("/user/{id}")
	public void delUser(@PathVariable int id,Model model) {
		userRepo.deleteById(id);

	}
	@Autowired
	private RedevanceRepo red;

	@RequestMapping(value = "/louer", method = RequestMethod.POST)
	public Locations Louer(@RequestBody Locations loc){
		locS.louer(loc);

		return loc;

	}
	/*@GetMapping("/check/{id}")
	public Locations checkLoc(@PathVariable int id,Model model) throws ParseException {
		Locations loc = locS.getLoc(id);
		Date d = new Date();




		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // format jour / mois / année
		LocalDate date1 = LocalDate.parse((CharSequence) d, format);
		LocalDate date2 = LocalDate.parse((CharSequence) loc.getdFinLocation(), format);
		Period period = Period.between(date2, date1);


		int montant = (int) (result*0.50);

		if (loc.getdDebutLocation().before(d) ) {
			Amendes amende = new Amendes();
			amende.setDateAmende(d);
			amende.setDelaiDepassement(result);
			amende.setMontant(montant);
			amende.setUser(loc.getUser());
			aRep.save(amende);

		}
		return loc;
	}*/
	@GetMapping("/check")
	public void checkAllLoc() {
	locS.check();
	
		
	}


	@GetMapping("/user")
	public List<Utilisateurs> allUser() {
		Utilisateurs user;

		return (List<Utilisateurs>) userRepo.findAll();
	}
	@RequestMapping(value = "/location", method = RequestMethod.GET)
	public Set<Locations> allLoc(Model model){
		return locS.allLoc();
	}
	@RequestMapping(value = "/crit", method = RequestMethod.POST)
	public void addCrit(@RequestBody Critiques crit) {
		userServ.addCrit(crit);
	}


	@RequestMapping(value = "/crit", method = RequestMethod.GET)
	public List<Critiques> allCrit(Model model) {
		List<Critiques> crit = (List<Critiques>) critRep.findAll();
		return crit;
	}
	@RequestMapping(value = "/help", method = RequestMethod.POST)
	public void help(@RequestBody Question question) {
		userServ.help(question);
	}
	
	
	@RequestMapping(value = "/role", method = RequestMethod.GET)
	public List<Roles> allRoles(Model model) {
		List<Roles> role = (List<Roles>) roleRepo.findAll();
		return role;
	}
}
