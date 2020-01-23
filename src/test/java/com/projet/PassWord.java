package com.projet;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.projet.services.Password;

class PassWord {

	@Test
	void test() {
		Password p = new Password("test");
		p.firstHash();
		System.out.print(p.getHash());
		fail("Not yet implemented");
	}

}
