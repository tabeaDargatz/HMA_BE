package com.td.HMA.repositories;

import com.td.HMA.DAOs.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
