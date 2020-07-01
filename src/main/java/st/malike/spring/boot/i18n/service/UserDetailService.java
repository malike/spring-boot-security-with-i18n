/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package st.malike.spring.boot.i18n.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author malike_st
 */
@Service
public class UserDetailService implements UserDetailsService, AuthenticationProvider {

  @Autowired
  private PasswordEncoder passwordEncoder;


  @Override
  public UserDetails loadUserByUsername(final String username) {
    throw new UsernameNotFoundException("Could not find user with name '" + username + "'");
  }

  @Override
  public Authentication authenticate(Authentication a) {

    throw new AuthenticationException("Could not find user") {
    };
  }

  @Override
  public boolean supports(Class<?> type) {
    return type.equals(UsernamePasswordAuthenticationToken.class);
  }


}
