package com.projet.services;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

import org.hibernate.hql.internal.ast.tree.DisplayableNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.beans.Critiques;
import com.projet.beans.Exemplaires;
import com.projet.beans.Question;
import com.projet.beans.Redevances;
import com.projet.beans.Reponse;
import com.projet.beans.Roles;
import com.projet.beans.Utilisateurs;
import com.projet.exceptions.ProduitIntrouvableException;
import com.projet.repositories.CritiqueRepository;
import com.projet.repositories.QuestionRepo;
import com.projet.repositories.RedevanceRepo;
import com.projet.repositories.ReponseRepo;
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
		//if (user.getRole() !=null) {

			Roles role = new Roles();

		role.setIdRole(1) ;
		role.setNom("lecteur");
		user.getRole().add(role);
		//if (user.getEmail().contains(user.getEmail())) {
		//	throw new ProduitIntrouvableException("email existant");
		//}
		user = userRepo.save(user);

		//}


		if (user != null) {
			return new ServiceRequest(true, "Saved successfully!");
		}
		return new ServiceRequest(false, "Dont saved!");
	}
	public ServiceRequest addBiblio(Utilisateurs user) {
					
			 Roles role = roleRepo.findById(2).get();
			
			user.getRole().add(role);
			user = userRepo.save(user);

			if (user != null) {
			return new ServiceRequest(true, "Saved successfully!");
		}
		return new ServiceRequest(false, "Dont saved!");
	}
	public ServiceRequest addMana(Utilisateurs user) {
		

		Roles role = roleRepo.findById(3).get();

			
			user.getRole().add(role);
			user = userRepo.save(user);

	

		if (user != null) {
			return new ServiceRequest(true, "Saved successfully!");
		}
		return new ServiceRequest(false, "Dont saved!");
	}


	public Utilisateurs promUser(int id, Utilisateurs user) {
		Roles role = new Roles();
		if (role.getIdRole() == 1) {
			
		
		role.setIdRole(2) ;
		role.setNom("bibliothequaire");
		roleRepo.save(role);
		user.getRole().add(role);
		user = userRepo.save(user);
		return user;
		}
		else if(role.getIdRole() == 2) {
			role.setIdRole(3) ;
			role.setNom("manaBiblio");
			roleRepo.save(role);
			user.getRole().add(role);
			user = userRepo.save(user);
		
		}
		else if(role.getIdRole() == 3) {
			role.setIdRole(4) ;
			role.setNom("manaGeneral");
			roleRepo.save(role);
			user.getRole().add(role);
			user = userRepo.save(user);
			
		}
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
	@Autowired
	private CritiqueRepository critRep;

	public Critiques addCrit(Critiques crit) {

		return critRep.save(crit);
	}

	@Autowired
	private QuestionRepo qRep;

	public Question help(Question question) {
		Date d = new Date();
		question.setDateQuestion(d);
		return qRep.save(question);

	}

	@Autowired
	private ReponseRepo rRep;

	public Reponse reply(Reponse reponse) {
		Date d = new Date();
		reponse.setDateQuestion(d);;
		return rRep.save(reponse);

	}
	public Set<Question> allQ(){
		Set<Question> q = new HashSet<Question>((Collection<Question>) qRep.findAll());
		return q;
	}


	@Autowired
	private RedevanceRepo redRep;
	
	public Redevances payeR(Redevances r ) {
		LocalDateTime t = LocalDateTime.now();
		Date d = new Date();
		Date dFR = Date.from( t.atZone( ZoneId.systemDefault()).toInstant().plusSeconds(31536000));
		r.setDatePaiementRedevance(d);
		r.setDateFinRedevance(dFR);
		r.setMontant((float) 25.50);
		redRep.save(r);
		return r;

	}









}

