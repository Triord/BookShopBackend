package com.projet.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.projet.beans.Livres;

public interface BookRepository extends CrudRepository<Livres, Integer> {
	/*@Query(value = "SELECT * from livre",nativeQuery=true)
	List<livres> findAll();*/
}
