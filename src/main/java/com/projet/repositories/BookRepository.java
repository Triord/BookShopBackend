package com.projet.repositories;




import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.projet.beans.Livres;
@Repository
public interface BookRepository extends CrudRepository<Livres, Integer> {
	@Query(value = "SELECT nom,isbn,descriptif,prix,edition from livre",nativeQuery=true)
	List<Livres> infoLivre();
}
