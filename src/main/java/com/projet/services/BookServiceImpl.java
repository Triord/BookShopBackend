package com.projet.services;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.beans.Exemplaires;
import com.projet.beans.Livres;
import com.projet.repositories.BookRepository;


@Service
public class BookServiceImpl implements BookService{
	
	@Autowired
	private BookRepository livreRep;

	public Set<Livres> allLivre(){
		Set<Livres> l = new HashSet<Livres>((Collection<Livres>) livreRep.findAll());
		return l;
	}
	public Optional<Livres> getId(int id ) {
		Optional<Livres> livre = livreRep.findById(id);
		return livre;
	}
	public Optional<Livres> infoLivre(int id) {
		Optional<Livres> livre = livreRep.findById(id);
		
		return livre;
	}

	public Livres UpdateBooks(long id, Livres livre) {
		livre = livreRep.save(livre);
		return livre;
	}
	public void DelBook(int id) {
		
		livreRep.deleteById(id);
	}

}
