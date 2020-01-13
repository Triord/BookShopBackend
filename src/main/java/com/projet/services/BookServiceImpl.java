package com.projet.services;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.projet.beans.Exemplaires;
import com.projet.beans.Livres;
import com.projet.repositories.BookRepository;
import com.projet.repositories.ExemplaireRepo;

@Service
public class BookServiceImpl implements BookService{
@Autowired
private BookRepository livreRep;
private ExemplaireRepo exRep;
	
	public Set<Livres> getSetLivres(){
		Set<Livres> l = new HashSet<Livres>((Collection<Livres>) livreRep.findAll());
		System.out.println(l);
		return l;
	}
	public Exemplaires getEx(int id){
    	Exemplaires ex  = exRep.findById((int) id).get();
    	return ex;
	}
}
