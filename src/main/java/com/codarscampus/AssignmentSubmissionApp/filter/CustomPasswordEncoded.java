package com.codarscampus.AssignmentSubmissionApp.filter;

import lombok.Getter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@Getter
public class CustomPasswordEncoded {
    private final PasswordEncoder passwordEncoder;

    public CustomPasswordEncoded() {
        this.passwordEncoder = new BCryptPasswordEncoder();
    }
}
