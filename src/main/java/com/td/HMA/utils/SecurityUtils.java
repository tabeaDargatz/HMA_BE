package com.td.HMA.utils;

import com.td.HMA.DLOs.User;
import java.util.Optional;
import lombok.experimental.UtilityClass;
import org.springframework.security.core.context.SecurityContextHolder;

@UtilityClass
public class SecurityUtils {

  public static Optional<User> getUser() {
    return Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication())
        .map(
            authentication ->
                authentication.getPrincipal() instanceof User
                    ? (User) authentication.getPrincipal()
                    : null);
  }
}
