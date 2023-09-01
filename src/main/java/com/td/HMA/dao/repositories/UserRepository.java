package com.td.HMA.dao.repositories;

import com.td.HMA.persist.beans.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
