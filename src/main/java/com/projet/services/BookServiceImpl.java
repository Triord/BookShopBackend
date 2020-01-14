package com.projet.services;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projet.beans.Livres;
import com.projet.repositories.BookRepository;


@Service
public class BookServiceImpl implements BookService{
	
	@Autowired
	private BookRepository livreRep;

	public Set<Livres> getSetLivres(){
		Set<Livres> l = new HashSet<Livres>((Collection<Livres>) livreRep.findAll());
		System.out.println(l);
		return l;
	}

	public Livres UpdateBooks(long id, Livres livre) {

		livre = livreRep.save(livre);
		return livre;
	}


}
