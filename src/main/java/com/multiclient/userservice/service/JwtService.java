package com.multiclient.userservice.service;

import com.multiclient.userservice.dao.CustomerRepository;
import com.multiclient.userservice.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JwtService implements UserDetailsService {
        @Autowired
        private CustomerRepository customerRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user=customerRepository.findByUserName(username);
        return new User(user.getUserName(),user.getPassword(),getRoles(user));
    }

    private Set<SimpleGrantedAuthority> getRoles(Users user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        List<String> roleList=new ArrayList<>();
        roleList.add("ADMIN");
        roleList.add("MERCHANT");
        roleList.add("CUSTOMER");
        roleList.forEach(role ->
            authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRole().getRole()))
        );
        return authorities;
    }
}
