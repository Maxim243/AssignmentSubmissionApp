package com.codarscampus.AssignmentSubmissionApp.controller;

import com.codarscampus.AssignmentSubmissionApp.domain.User;
import com.codarscampus.AssignmentSubmissionApp.dto.AuthCredentialsRequestDTO;
import com.codarscampus.AssignmentSubmissionApp.filter.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtil jwtTokenUtil;

    @PostMapping("login")
    public ResponseEntity<?> login(@RequestBody AuthCredentialsRequestDTO authCredentialsRequestDTO) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authCredentialsRequestDTO.getUsername(),
                            authCredentialsRequestDTO.getPassword()
                    )
            );

            User user = (User) authentication.getPrincipal();
            user.setPassword(null);
            return ResponseEntity.ok()
                    .header(HttpHeaders.AUTHORIZATION, jwtTokenUtil.generateToken(user))
                    .body(user);
        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
