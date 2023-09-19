package com.td.HMA.security;

import com.td.HMA.DatabaseAccess.UserDataAccess;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private final UserDataAccess userDataAccess;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userDataAccess.findSecurityUserByEmail(email).orElseThrow(()-> new NullPointerException(""));
    }
}
