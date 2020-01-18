package com.projet.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.projet.beans.Utilisateurs;
@Repository
public interface UserRepository extends CrudRepository<Utilisateurs, Integer>{
	//@Query(value="SELECT EMAIL from utilisateurs")
	//Optional<Utilisateurs> findByStudentMail(String email);
	Utilisateurs findByEmail(String email);

	Utilisateurs findByUsername(String email);
}
