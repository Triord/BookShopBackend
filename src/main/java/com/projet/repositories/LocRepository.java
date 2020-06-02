package com.projet.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.projet.beans.Locations;
@Repository
public interface LocRepository extends CrudRepository<Locations, Integer>{

	@Query(value ="select * from locations l join utilisateurs u on l.idUtilisateur=u.idUtilisateur where l.idUtilisateur = :id", nativeQuery =true)
	List <Locations> findLocByIdUser(int id);
}
