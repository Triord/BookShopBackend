package com.projet.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.projet.beans.Bibliotheque;

public interface biblioRepo extends CrudRepository<Bibliotheque, Integer>{
	@Query(value ="SELECT* FROM BIBLIOTHEQUES ",nativeQuery = true)
	List<Bibliotheque> allBiblio();
}
