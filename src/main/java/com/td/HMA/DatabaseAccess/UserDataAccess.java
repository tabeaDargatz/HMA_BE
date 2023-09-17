package com.td.HMA.DatabaseAccess;

import com.td.HMA.DLOs.CreateUser;
import com.td.HMA.DLOs.User;
import com.td.HMA.mappers.DaoToDomainMapper;
import com.td.HMA.mappers.DomainToDaoMapper;
import com.td.HMA.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class UserDataAccess {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DaoToDomainMapper daoToDomainMapper;
    @Autowired
    private DomainToDaoMapper domainToDaoMapper;

    public Optional<User> findById(Integer id) {
        return userRepository.findById(id).map(daoToDomainMapper::mapToDomain);
    }

    public Optional<org.springframework.security.core.userdetails.User> findSecurityUserByEmail(String email) {
        Optional<com.td.HMA.DAOs.User> user = userRepository.findByEmail(email);
        return user.map(this::convertToSecurityUser);
    }

    private org.springframework.security.core.userdetails.User convertToSecurityUser(com.td.HMA.DAOs.User user) {
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), Collections.emptyList());
    }

    public User createUser(CreateUser createUser) {
        return daoToDomainMapper.mapToDomain(userRepository.saveAndFlush(domainToDaoMapper.mapToDao(createUser)));
    }
}
