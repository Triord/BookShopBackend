package com.projet.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.projet.beans.Critiques;
@Repository
public interface CritiqueRepository extends CrudRepository<Critiques, Integer> {

}
