package com.projet.repositories;




import org.springframework.data.repository.CrudRepository;

import com.projet.beans.Livres;

public interface BookRepository extends CrudRepository<Livres, Integer> {
	/*@Query(value = "SELECT * from livre",nativeQuery=true)
	List<livres> findAll();*/
}
