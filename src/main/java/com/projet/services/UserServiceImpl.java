package com.projet.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.*;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.beans.Roles;
import com.projet.beans.Utilisateurs;
import com.projet.repositories.RoleRepository;
import com.projet.repositories.UserRepository;
import com.projet.services.UserServiceImpl;


@Service
public class UserServiceImpl implements UserService  {


	@Autowired
	private UserRepository userRepo;
	@Autowired
	private RoleRepository roleRepo;


	public Set<Utilisateurs> allUser(){
		Set<Utilisateurs> u = new HashSet<Utilisateurs>((Collection<Utilisateurs>) userRepo.findAll());
		return u;
	}


	public List<Utilisateurs> findAll() {
		List<Utilisateurs> list = new ArrayList<>();
		userRepo.findAll().iterator().forEachRemaining(list::add);
		return list;
	}
	public ServiceRequest addUser(String nom ,String username, String prenom ,Date dDN,int numNat,String email,String mdp,List<Integer> idRole ) {
		Utilisateurs user = new Utilisateurs();
		user.setNom(nom);
		user.setUsername(username);
		user.setPrenom(prenom);
		user.setdDN(dDN);
		user.setNumNat(numNat);
		user.setEmail(email);
		user.setMdp(mdp);
		user.setRole(new HashSet<Roles>((Collection<? extends Roles>) roleRepo.findAllById(idRole)));

		user = userRepo.save(user);
		if (user != null) {
			return new ServiceRequest(true, "Saved successfully!");
		}
		return new ServiceRequest(false, "Dont saved!");
	}


	public Utilisateurs promUser(int id, Utilisateurs user) {
		Roles role = new Roles();

		role.setIdRole(2) ;
		role.setNom("bibliothequaire");
		roleRepo.save(role);
		user.getRole().add(role);
		user = userRepo.save(user);
		return user;
	}
	
	public Utilisateurs promBiblio(int id, Utilisateurs user) {
		Roles role = new Roles();
		
		role.setIdRole(3) ;
		role.setNom("ManaBiblio");
		roleRepo.save(role);
		user.getRole().add(role);
		user = userRepo.save(user);
		return user;
	}
	public Utilisateurs retroUser(int id, Utilisateurs user) {
		Roles role = new Roles();
		
		role.setIdRole(1) ;
		role.setNom("lecteur");
		roleRepo.save(role);
		user.getRole().add(role);
		user = userRepo.save(user);
		return user;
	}









}

