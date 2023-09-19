package com.td.HMA.controllers;

import com.td.HMA.DTOs.user.CreateUser;
import com.td.HMA.DTOs.user.UserDetails;
import com.td.HMA.mappers.DTOToDomainMapper;
import com.td.HMA.mappers.DomainToDTOMapper;
import com.td.HMA.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rest")
public class UserController {

  @Autowired private UserService userService;
  @Autowired private DomainToDTOMapper domainToDTOMapper;
  @Autowired private DTOToDomainMapper dtoToDomainMapper;
  @Autowired private DelegatingPasswordEncoder delegatingPasswordEncoder;

  @GetMapping("/users/{id}")
  public ResponseEntity<UserDetails> getUser(@PathVariable Integer id) {
    return ResponseEntity.ok(domainToDTOMapper.mapToDTO(userService.getUserById(id)));
  }

  @PostMapping("/users")
  public ResponseEntity<UserDetails> createUser(@RequestBody CreateUser createUser) {
    createUser.setPassword(delegatingPasswordEncoder.encode(createUser.getPassword()));
    UserDetails userDetails =
        domainToDTOMapper.mapToDTO(userService.createUser(domainToDTOMapper.mapToDTO(createUser)));
    return ResponseEntity.created(
            ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/{id}")
                .buildAndExpand(userDetails.getId())
                .toUri())
        .body(userDetails);
  }
}
