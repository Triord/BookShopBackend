package com.projet.services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.projet.beans.Amendes;
import com.projet.beans.Exemplaires;
import com.projet.beans.Livres;
import com.projet.beans.Locations;
import com.projet.beans.Utilisateurs;
import com.projet.exceptions.ProduitIntrouvableException;
import com.projet.repositories.AmendeRepo;
import com.projet.repositories.BookRepository;
import com.projet.repositories.ExemplaireRepo;
import com.projet.repositories.LocRepository;
@Service
public class LocationServiceImpl implements LocationService {
	
	@Autowired
	private BookRepository bkRep;
	@Autowired
	private LocRepository lkRep;
	
	
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
	public Locations louer(Locations loc) {
		LocalDateTime t = LocalDateTime.now();
		Date dateLoc = Date.from( t.atZone( ZoneId.systemDefault()).toInstant());
		Date dateDebutLoc = Date.from( t.atZone( ZoneId.systemDefault()).toInstant().plusSeconds(86400));
		Date dateFinLoc = Date.from( t.atZone( ZoneId.systemDefault()).toInstant().plusSeconds(2592000));
		loc.setDateLocation(dateLoc);
		loc.setdDebutLocation(dateDebutLoc);
		loc.setdFinLocation(dateFinLoc);
		
		
		Livres book = bkRep.findById(loc.getLivre().getIdlivre()).get();
		
		
		if (!book.getEtat()) {
			throw new ProduitIntrouvableException("le livre est indisponible");
		}


		lkRep.save(loc);
		return loc;
	}
	@Autowired 
	private AmendeRepo aRep;
	@Autowired
	private LocationServiceImpl locS;
	
	public void check() {
		
		Set <Locations> loc =  locS.allLoc();

		for (Locations lo : loc) {
			Date d = new Date();

			DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");


			Long n =  lo.getdFinLocation().getTime() - d.getTime() ; 
			n = (n / (1000 * 60 * 60 * 24) + 1);

			int delai = n.intValue();

			int montant = (int) (delai*0.50);


			if (lo.getdFinLocation().before(d) ) {
				Amendes amende = new Amendes();
				amende.setDateAmende(d);
				amende.setDelaiDepassement(delai);
				amende.setMontant(montant);
				amende.setUser(lo.getUser());
				aRep.save(amende);

			}
		}
		
		// TODO Auto-generated method stub
		
	}
	}
