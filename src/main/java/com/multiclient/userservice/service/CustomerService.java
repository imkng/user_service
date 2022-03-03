package com.multiclient.userservice.service;

import com.multiclient.userservice.dao.CustomerRepository;

import com.multiclient.userservice.entity.Users;
import com.multiclient.userservice.exception.CustomerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    PasswordEncoder passwordEncoder;
    public Users saveCustomer(Users customer) {
        customer.setPassword(encodePassword(customer.getPassword()));
        return customerRepository.save(customer);
    }

    public Users fetchUserByEmailId(String email){

        return customerRepository.findByEmail(email);
    }


    public Users getCustomerById(Integer id) throws CustomerNotFoundException {
        return customerRepository.findById(id).orElseThrow(CustomerNotFoundException::new);
    }

     public String encodePassword(String password){
        return passwordEncoder.encode(password);
    }


}
