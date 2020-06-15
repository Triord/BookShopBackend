package com.projet.controllers;
import java.security.Principal;
import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javassist.expr.Instanceof;
@Controller
public class MVCController {
  @RequestMapping(value = "/username", method = RequestMethod.GET)
  @ResponseBody
  public Collection<? extends GrantedAuthority> currentUserName(Authentication principal) {
	  
     return principal.getAuthorities();
  }
}