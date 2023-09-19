package com.td.HMA.DTOs.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDetails {
    private Integer id;
    private String email;
    private String username;
  private Integer version;
}
