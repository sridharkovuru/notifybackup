package com.notify.spring.security.customizations;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.notify.model.B2BUser;
import com.notify.services.B2BUserService;

 
@Service
public class MyUserServiceImpl implements  UserDetailsService {
 
 @Autowired
 B2BUserService b2bUserService;

 public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
 
  B2BUser b2bUser = b2bUserService.getB2BUser(username);
  if(b2bUser == null)
  {
	  throw new UsernameNotFoundException("User Not Found");
  }
  Collection<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
  SimpleGrantedAuthority userAuthority = new SimpleGrantedAuthority(
    "ROLE_USER");
  SimpleGrantedAuthority managerAuthority = new SimpleGrantedAuthority(
    "ROLE_MANAGER");
  SimpleGrantedAuthority adminAuthority = new SimpleGrantedAuthority(
		    "ROLE_ADMIN");
  if(b2bUser.getRoles().contains("user"))
  {
	   authorities.add(userAuthority);
  }
  if(b2bUser.getRoles().contains("manager"))
  {
	   authorities.add(managerAuthority);
  }
  if(b2bUser.getRoles().contains("admin"))
  {
	   authorities.add(adminAuthority);
  }
  
  UserDetails user = new User(b2bUser.getEmail(),
		  b2bUser.getPassword(), true, true, true, true, authorities);
  return user;
 }
 
}