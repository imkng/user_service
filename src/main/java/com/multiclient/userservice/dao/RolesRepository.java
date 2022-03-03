package com.multiclient.userservice.dao;

import com.multiclient.userservice.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepository extends JpaRepository<Roles,Long > {
}
