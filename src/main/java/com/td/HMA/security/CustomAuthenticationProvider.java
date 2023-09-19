package com.td.HMA.security;

import com.td.HMA.DLOs.User;
import com.td.HMA.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@RequiredArgsConstructor
public class CustomAuthenticationProvider extends DaoAuthenticationProvider {

  @Autowired private final UserService userService;

  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    Authentication auth = super.authenticate(authentication);
    User user =
        userService
            .findByEmail(authentication.getName())
            .orElseThrow(() -> new UsernameNotFoundException("ERROR.EMAIL_NOT_FOUND"));
    if (auth.isAuthenticated()) {
      resetFailedLoginsCount(user);
    }
    return auth;
  }

  @Override
  protected void additionalAuthenticationChecks(
      UserDetails userDetails, UsernamePasswordAuthenticationToken authentication)
      throws AuthenticationException {
    User user =
        userService
            .findByEmail(authentication.getName())
            .orElseThrow(() -> new UsernameNotFoundException("ERROR.EMAIL_NOT_FOUND"));
    authentication.setDetails(user);
  }

  private void resetFailedLoginsCount(User user) {
    // TODO: implement failed login counter
  }
}
