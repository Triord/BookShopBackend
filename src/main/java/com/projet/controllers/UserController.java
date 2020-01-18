package com.projet.controllers;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projet.beans.Livres;
import com.projet.beans.Roles;
import com.projet.beans.Utilisateurs;
import com.projet.repositories.RoleRepository;
import com.projet.repositories.UserRepository;
import com.projet.services.ServiceRequest;
import com.projet.services.UserServiceImpl;

@RestController
public class UserController {

	@Autowired
	private UserServiceImpl userServ;

	@Autowired
	private UserRepository userRepo;
	private RoleRepository roleRepo;
	
	@PostMapping("/user")
	public Utilisateurs addUser(@RequestBody Utilisateurs user) {
		Roles role = new Roles();
		role.setIdRole(1);
		role.setNom("lecteur");
		user.getRole().add(role);
		
		return userRepo.save(user);
		
		}
	
	@PutMapping("/user/{id}")
	public Utilisateurs promUser(@RequestBody Utilisateurs user, @PathVariable int id) {
		return userServ.promUser(id, user);
	}
	@PutMapping("/bibliothequaire/{id}")
	public Utilisateurs promBiblio(@RequestBody Utilisateurs user, @PathVariable int id) {
		return userServ.promBiblio(id, user);
	}
	@PutMapping("/lecteur/{id}")
	public Utilisateurs retroUser(@RequestBody Utilisateurs user, @PathVariable int id) {
		return userServ.retroUser(id, user);
	}
	
	@GetMapping("/user")
	public Set<Utilisateurs> allUser(Model model) {
		return userServ.allUser();
	}
	
	
	
}
