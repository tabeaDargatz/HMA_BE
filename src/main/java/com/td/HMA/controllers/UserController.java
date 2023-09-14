package com.td.HMA.controllers;

import com.td.HMA.DTOs.user.UserDetails;
import com.td.HMA.mappers.DomainToDTOMapper;
import com.td.HMA.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rest")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private DomainToDTOMapper domainToDTOMapper;

    //TODO: figure out pw encryption
    @GetMapping("/users/{id}")
    public UserDetails getUser(@PathVariable Integer id) {
        return domainToDTOMapper.mapToDTO(userService.getUser(id));
    }

}
