package com.projet.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.projet.beans.Exemplaires;
import java.util.*;

@Repository
public interface ExemplaireRepo extends CrudRepository<Exemplaires, Integer> {
	/*@Query(value = "SELECT * from exemplaires",nativeQuery=true)
	List<Exemplaires> findExemplaire();*/
}
