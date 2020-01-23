package com.projet.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.beans.Exemplaires;
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
	
	public Utilisateurs getUser(int id){
		Utilisateurs user  = userRepo.findById(id).get();
		return user;
	}

	public List<Utilisateurs> findAll() {
		List<Utilisateurs> list = new ArrayList<>();
		userRepo.findAll().iterator().forEachRemaining(list::add);
		return list;
	}
	public ServiceRequest addUser(Utilisateurs user) {
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

