package com.projet.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;

import com.projet.beans.Question;
@Controller
public interface QuestionRepo extends CrudRepository<Question, Integer> {

}
