package com.projet.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;

import com.projet.beans.Reponse;

@Controller
public interface ReponseRepo extends CrudRepository<Reponse, Integer>{

}
