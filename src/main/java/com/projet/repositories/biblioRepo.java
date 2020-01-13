package com.projet.repositories;

import org.springframework.data.repository.CrudRepository;

import com.projet.beans.Bibliotheque;

public interface biblioRepo extends CrudRepository<Bibliotheque, Integer>{

}
