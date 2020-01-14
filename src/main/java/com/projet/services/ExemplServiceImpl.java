package com.projet.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.beans.Exemplaires;
import com.projet.repositories.ExemplaireRepo;

@Service
public class ExemplServiceImpl implements ExemplService {
	@Autowired
	private ExemplaireRepo exRep;

	public Exemplaires getEx(int id){
		Exemplaires ex  = exRep.findById(id).get();
		return ex;
	}
}
