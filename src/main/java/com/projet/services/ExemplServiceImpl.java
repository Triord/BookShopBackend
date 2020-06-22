package com.projet.services;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import com.projet.beans.Exemplaires;

import com.projet.repositories.ExemplaireRepo;

@Service
public class ExemplServiceImpl implements ExemplService {
	@Autowired
	private ExemplaireRepo exRep;

	public Exemplaires getEx(int id){
		Exemplaires ex  = exRep.findById(id).get();
		return ex;
	}
	public Set<Exemplaires> allEx(){
		Set<Exemplaires> ex = new HashSet<Exemplaires>((Collection<Exemplaires>) exRep.findAll());
		return ex;
	} 
	
	
	
}	
