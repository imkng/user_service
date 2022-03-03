package com.multiclient.userservice.dao;

import com.multiclient.userservice.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Users,Integer>{


    Users findByEmail(String email);

    Users findByUserName(String username);
}
