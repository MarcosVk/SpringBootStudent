package com.example.demo.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private StudentRepository repository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Student student=repository.findByUsername(username)
                .orElseThrow(()->new UsernameNotFoundException("Username Not Found"));
        return new User(student.getUsername(),student.getPassword(), Collections.singleton(new SimpleGrantedAuthority("USER_ROLE")));
    }
}
