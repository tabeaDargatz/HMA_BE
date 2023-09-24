package com.td.HMA.utils;

import java.util.Optional;
import lombok.experimental.UtilityClass;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

@UtilityClass
public class SecurityUtils {

  public static Optional<User> getUser() {
    return Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication())
        .map(authentication -> (User) authentication.getPrincipal());
  }
}
