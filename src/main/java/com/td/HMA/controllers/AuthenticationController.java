package com.td.HMA.controllers;


import com.td.HMA.DTOs.AuthenticationRequest;
import com.td.HMA.security.JwtUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JwtUtils jwtUtils;

  @PostMapping("/login")
  public ResponseEntity<String> authenticate(
      @RequestBody AuthenticationRequest authenticationRequest) {
      log.error("TEST");
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(), authenticationRequest.getPassword()));
        final UserDetails user = userDetailsService.loadUserByUsername(authenticationRequest.getEmail());
        if (user == null) {
            throw new NullPointerException("AA");
        }
        String jwt = jwtUtils.generateToken(user);
       log.error("JWT: "+jwt);
    return ResponseEntity.ok(jwt);
    }

}
