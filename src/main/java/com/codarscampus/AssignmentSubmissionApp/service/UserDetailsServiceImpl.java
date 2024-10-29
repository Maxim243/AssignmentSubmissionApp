package com.codarscampus.AssignmentSubmissionApp.service;

import com.codarscampus.AssignmentSubmissionApp.domain.User;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @SneakyThrows
    public UserDetails loadUserByUsername(String username) {
        return User
                .builder()
                .id(1L)
                .username(username)
                .password(passwordEncoder.encode("maxim1"))
                .build();
    }
}
