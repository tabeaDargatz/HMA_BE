package com.td.HMA.controller;

import com.td.HMA.bl.UserService;
import com.td.HMA.persist.beans.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rest")
public class UserController {
    @Autowired

    private UserService userService;

    @GetMapping("/users")
    public List<User> getUsers(){
        return userService.getUsers();
    }
}
