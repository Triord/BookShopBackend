package com.projet.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.projet.beans.Amendes;
import com.projet.beans.Bibliotheque;
import com.projet.beans.Exemplaires;
import com.projet.beans.Livres;
import com.projet.beans.Locations;
import com.projet.beans.Roles;
import com.projet.beans.Utilisateurs;
import com.projet.exception.LocationException;
import com.projet.repositories.AmendeRepo;
import com.projet.repositories.LocRepository;
import com.projet.repositories.RoleRepository;
import com.projet.repositories.UserRepository;
import com.projet.services.LocationService;
import com.projet.services.LocationServiceImpl;
import com.projet.services.ServiceRequest;
import com.projet.services.UserServiceImpl;

@RestController
public class UserController {

	@Autowired
	private UserServiceImpl userServ;
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

	@PostMapping("/user")
	public ServiceRequest addUser(@RequestBody Utilisateurs user) {

		return userServ.addUser(user);
		/*Roles role = new Roles();
		role.setIdRole(1);
		role.setNom("lecteur");
		user.getRole().add(role);

		return userRepo.save(user);*/
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
	@PostMapping("/louer")
	public Locations Louer(@RequestBody Locations loc){


		LocalDateTime t = LocalDateTime.now();
		Date dateLoc = Date.from( t.atZone( ZoneId.systemDefault()).toInstant());
		Date dateDebutLoc = Date.from( t.atZone( ZoneId.systemDefault()).toInstant().plusSeconds(86400));
		Date dateFinLoc = Date.from( t.atZone( ZoneId.systemDefault()).toInstant().plusSeconds(2592000));
		loc.setDateLocation(dateLoc);
		loc.setdDebutLocation(dateDebutLoc);
		loc.setdFinLocation(dateFinLoc);

		return locRep.save(loc);
	}
	@GetMapping("/check/{id}")
	public Locations checkLoc(@PathVariable int id,Model model) {
		Locations loc = locS.getLoc(id);
		Date d = new Date();
		
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		String s = dateFormat.format(d);
		String s2 = dateFormat.format(loc.getdDebutLocation());
		int i = Integer.parseInt(s);
		int i2 = Integer.parseInt(s2);
		
		int result = i-i2;
		
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
	}
	@GetMapping("/check")
	public Set <Locations> checkAllLoc(Model model) {
		Set <Locations> loc =  locS.allLoc();
	
for (Locations lo : loc) {
		Date d = new Date();
		
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		String s = dateFormat.format(d);
		String s2 = dateFormat.format(lo.getdDebutLocation());
		int i = Integer.parseInt(s);
		int i2 = Integer.parseInt(s2);
		
		int result = i-i2;
		
		int montant = (int) (result*0.50);
	
	
		if (lo.getdDebutLocation().before(d) ) {
			Amendes amende = new Amendes();
			amende.setDateAmende(d);
			amende.setDelaiDepassement(result);
			amende.setMontant(montant);
			amende.setUser(lo.getUser());
			aRep.save(amende);
			
		}
}
	
		return loc;
	}


	@GetMapping("/user")
	public Set<Utilisateurs> allUser(Model model) {
		return userServ.allUser();
	}
	@RequestMapping(value = "/location", method = RequestMethod.GET)
	public Set<Locations> allLoc(Model model){
		return locS.allLoc();
	}

}
