package com.projet.services;

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

import com.projet.beans.Exemplaires;
import com.projet.beans.Livres;
import com.projet.beans.Locations;
import com.projet.beans.Utilisateurs;
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
	}
