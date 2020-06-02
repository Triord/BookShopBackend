package com.projet.jwt;

import java.util.*;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.projet.beans.Roles;

public class JwtUserDetails implements UserDetails {

  private static final long serialVersionUID = 5155720064139820502L;

  private final int id;
  private final String email;
  private final String mdp;
  private final Collection<? extends GrantedAuthority> authorities;
  

  public JwtUserDetails(int id, String email, String mdp, Set<Roles> set) {
    this.id = id;
    this.email = email;
    this.mdp = mdp;
   
    List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
    
    //String[] roles = set.split(",");
    for(Roles r:set) {
    	authorities.add(new SimpleGrantedAuthority("ROLE_"+r.getNom()));
    }

    this.authorities = authorities;
    
    
  }
  	
 

@JsonIgnore
  public int getId() {
    return id;
  }

  @Override
  public String getUsername() {
    return email;
  }

  @JsonIgnore
  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @JsonIgnore
  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @JsonIgnore
  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @JsonIgnore
  @Override
  public String getPassword() {
    return mdp;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return authorities;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}

