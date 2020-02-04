package com.projet.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.projet.beans.Livres;
import com.projet.beans.Utilisateurs;
@Repository
public interface UserRepository extends CrudRepository<Utilisateurs, Integer>{
	Optional<Utilisateurs> findByEmail(String email);
	
}
