package com.projet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;


import com.projet.repositories.BookRepository;
import com.projet.services.BookServiceImpl;
@Component
public class Home implements ApplicationRunner{

	@Override
	public void run(ApplicationArguments args) {
		
		
		System.out.println("bite");
	}

}
