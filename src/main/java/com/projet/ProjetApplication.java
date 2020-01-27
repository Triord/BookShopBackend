package com.projet;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjetApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetApplication.class, args);
		LocalDateTime t = LocalDateTime.now();
		Date dateLoc = Date.from( t.atZone( ZoneId.systemDefault()).toInstant());
		Date dateDebutLoc = Date.from( t.atZone( ZoneId.systemDefault()).toInstant().plusSeconds(86400));
		Date dateFinLoc = Date.from( t.atZone( ZoneId.systemDefault()).toInstant().plusSeconds(2592000));
		int compare = dateFinLoc.compareTo(dateDebutLoc);
		System.out.println(dateDebutLoc);
	}

}
