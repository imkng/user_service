package com.multiclient.userservice.service;

import com.multiclient.userservice.dao.RolesRepository;
import com.multiclient.userservice.entity.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolesService {
    @Autowired
    RolesRepository rolesRepository;

    public Roles addRoles(Roles roles){
        return rolesRepository.save(roles);
    }


}
