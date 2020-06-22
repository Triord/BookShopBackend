package com.projet.services;

import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.omg.CORBA.portable.ValueOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.projet.beans.Amendes;
import com.projet.beans.Exemplaires;
import com.projet.beans.Livres;
import com.projet.beans.Locations;
import com.projet.beans.Roles;
import com.projet.beans.Utilisateurs;
import com.projet.exceptions.ProduitIntrouvableException;
import com.projet.jwt.JwtUserDetails;
import com.projet.repositories.AmendeRepo;
import com.projet.repositories.BookRepository;
import com.projet.repositories.ExemplaireRepo;
import com.projet.repositories.LocRepository;
import com.projet.repositories.UserRepository;
@Service
public class LocationServiceImpl implements LocationService {
	
	@Autowired
	private BookRepository bkRep;
	@Autowired
	private LocRepository lkRep;
	@Autowired
	private ExemplaireRepo exRep;
	@Autowired
	private UserRepository uRep;
	
	public Set<Locations> allLoc(){
		Set<Locations> l = new HashSet<Locations>((Collection<Locations>) lkRep.findAll());
		return l;
	}
	public Locations getLoc(int id){
		Locations loc  = lkRep.findById(id).get();
		return loc;
	}
	public Locations addLoc(Locations loc) {
		return lkRep.save(loc);
		
	}
	
	
	public Locations louer(Locations loc){
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof JwtUserDetails  ) {
		int id = ((JwtUserDetails)principal).getId();
		
		System.out.println(((JwtUserDetails)principal).getAuthorities());
		Utilisateurs user = new Utilisateurs();
		user.setIdUtilisateur(id);
		
		LocalDateTime t = LocalDateTime.now();
		
		Date dateLoc = Date.from( t.atZone( ZoneId.systemDefault()).toInstant());
		Date dateDebutLoc = Date.from( t.atZone( ZoneId.systemDefault()).toInstant().plusSeconds(86400));
		System.out.println(dateDebutLoc);
		Date dateFinLoc = Date.from( t.atZone( ZoneId.systemDefault()).toInstant().plusSeconds(2592000));
		loc.setDateLocation(dateLoc);
		loc.setdDebutLocation(dateDebutLoc);
		loc.setdFinLocation(dateFinLoc);
		loc.setUser(user);
		
		
		} else {
		String id = principal.toString();
		}
		

		
		//Livres book = bkRep.findById(loc.getLivre().getIdlivre()).get();
		
		
	//	if (!book.getEtat()) {
			//throw new ProduitIntrouvableException("le livre est indisponible");
		//}
	
		
		Utilisateurs user = loc.getUser();
		int id = user.getIdUtilisateur();
		Optional<Utilisateurs> userr= uRep.findById(id);
		System.out.println(userr.get().isEtat());
		
		if (!userr.get().isEtat()) {
			System.out.println("loc accepté");
		
		
		lkRep.save(loc);
		for(Livres l: loc.getLivre()) {
			int retrait = l.getQuantity();
			retrait-- ;
			retrait += 1;
			System.out.println(retrait);
			l.setQuantity(retrait);
			if (l.getQuantity() <=0) {
				l.setEtat(true);
			}
			
			bkRep.save(l);
			}
		}
		else {
			System.out.println("erreur");
		}
		return loc;
	}
	@Autowired 
	private AmendeRepo aRep;
	@Autowired
	private LocationServiceImpl locS;
	
	public Amendes check() {
		
		Set <Locations> loc =  locS.allLoc();
		Amendes amende = new Amendes();
		
		for (Locations lo : loc) {
			Date d = new Date();

			DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");


			Long n =  lo.getdFinLocation().getTime() - d.getTime() ; 
			n = (n / (1000 * 60 * 60 * 24) + 1);

			int delai = n.intValue();

			int montant = (int) (delai*-0.50);


			if (lo.getdFinLocation().before(d) ) {
				
				amende.setDateAmende(d);
				amende.setDelaiDepassement(Math.abs(delai));
				amende.setMontant(montant);
				amende.setUser(lo.getUser());
				Utilisateurs user = lo.getUser();
				user.setEtat(true);
				uRep.save(user);
				aRep.save(amende);

			}
			
		}
		return amende;
		
		// TODO Auto-generated method stub
		
	}
	
	public List<Locations> locByIdUSer(){
	Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	int id = -1;
	if (principal instanceof JwtUserDetails) {
	id = ((JwtUserDetails)principal).getId();
	
	
	
	}
	return lkRep.findLocByIdUser(id);
	}
	
	
	
	

	
	
	}
