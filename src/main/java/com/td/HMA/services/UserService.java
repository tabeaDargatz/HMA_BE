package com.td.HMA.services;

import com.td.HMA.DLOs.CreateUser;
import com.td.HMA.DLOs.User;
import com.td.HMA.DatabaseAccess.UserDataAccess;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    private UserDataAccess userDataAccess;

    //TODO: add actual exceptions
    public User getUserById(Integer id) {
        return userDataAccess.findById(id).orElseThrow(() -> new NullPointerException("AAA"));
    }

    public User createUser(CreateUser createUser) {
        return userDataAccess.createUser(createUser);
    }

  public Optional<User> findByEmail(String email) {
    return userDataAccess.findByEmail(email);
  }
}
