package com.td.HMA.services;

import com.td.HMA.DLOs.User;
import com.td.HMA.DatabaseAccess.UserDataAccess;
import com.td.HMA.mappers.DaoToDomainMapper;
import com.td.HMA.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    private UserDataAccess userDataAccess;

    //TODO: add actual exceptions
    public User getUser(Integer id) {
        return userDataAccess.findById(id).orElseThrow(() -> new NullPointerException("AAA"));
    }
}
