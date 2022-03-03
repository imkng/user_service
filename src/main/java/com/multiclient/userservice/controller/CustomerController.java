package com.multiclient.userservice.controller;

import com.multiclient.userservice.config.JwtUtil;
import com.multiclient.userservice.dto.UsersDto;
import com.multiclient.userservice.entity.JwtRequest;
import com.multiclient.userservice.entity.Users;
import com.multiclient.userservice.exception.*;
import com.multiclient.userservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class CustomerController {
    @Autowired
    CustomerService customerService;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtUtil jwtUtil;

    @PostMapping("/registration")
    public Users registerCustomer(@RequestBody UsersDto customer) throws EmailAlreadyExistException, EmailIdFormatException {
        String tempEmailId = customer.getEmail();
        System.out.println("Welcome");
        Users user=new Users();
        if (tempEmailId != null && !"".equals(tempEmailId)) {
            Users userObj = customerService.fetchUserByEmailId(tempEmailId);
            if (userObj != null) {
                throw new EmailAlreadyExistException("User with " + tempEmailId + " is already Exist");
            }
        }
        else if (customer.getEmail().isEmpty() || customer.getEmail().isBlank() || !customer.getEmail().matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$")) {
            throw new EmailIdFormatException("Email Id is Wrong format");
        }
        else{
            user.setUserId(customer.getUserId());
            user.setUserName(customer.getUserName());
            user.setMobileNumber(customer.getMobileNumber());
            user.setEmail(customer.getEmail());
            user.setAddress(customer.getAddress());
            user.setRole(customer.getRole());
            user.setPassword(customer.getPassword());
        }
        return customerService.saveCustomer(user);
    }
    @GetMapping("/getcustomer/{id}")
    @PreAuthorize("hasRole('ROLE_CUSTOMER') or hasRole('ROLE_MERCHANT') or hasRole('ROLE_ADMIN')")
    public Users getCustomerById(@PathVariable("id") Integer id) throws CustomerNotFoundException {
        return customerService.getCustomerById(id);
    }
    @PostMapping("/authenticate")
    public String authenticate(@RequestBody JwtRequest jwtRequest) throws IncorrectCredentials {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUserName(), jwtRequest.getPassword()));
        } catch (Exception ex) {
            throw new IncorrectCredentials();
        }
        return jwtUtil.generateToken(jwtRequest.getUserName());
    }
}




