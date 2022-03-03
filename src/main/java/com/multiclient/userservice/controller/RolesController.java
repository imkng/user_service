package com.multiclient.userservice.controller;

import com.multiclient.userservice.dto.RolesDto;
import com.multiclient.userservice.entity.Roles;
import com.multiclient.userservice.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/roles")
public class RolesController{

    @Autowired
    RolesService rolesService;

    @GetMapping("/addroles")
    public Roles addRoles(@RequestBody RolesDto rolesDto){
        Roles roles=new Roles();
        roles.setRoleId(rolesDto.getRoleId());
        roles.setRole(rolesDto.getRole());
        return rolesService.addRoles(roles);
    }

}
