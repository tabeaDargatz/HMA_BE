package com.td.HMA.DatabaseAccess;

import com.td.HMA.DLOs.User;
import com.td.HMA.mappers.DaoToDomainMapper;
import com.td.HMA.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDataAccess {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DaoToDomainMapper daoToDomainMapper;

    public Optional<User> findById(Integer id) {
        return userRepository.findById(id).map(daoToDomainMapper::mapToDomain);
    }
}
