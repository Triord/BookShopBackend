package com.projet.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;

import com.projet.beans.Redevances;
@Controller
public interface RedevanceRepo extends CrudRepository<Redevances, Integer> {

}
