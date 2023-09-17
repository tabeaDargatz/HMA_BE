package com.td.HMA.DTOs.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateUser {
    private String email;
    private  String password;
    private String username;
}
