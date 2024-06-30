package com.anhduc.backend.service;

import com.anhduc.backend.entity.User;
import com.anhduc.backend.entity.VerificationToken;
import com.anhduc.backend.repository.VerificationTokenRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class VerificationTokenService {

    private final VerificationTokenRepository verificationTokenRepository;

    public VerificationTokenService(VerificationTokenRepository verificationTokenRepository) {
        this.verificationTokenRepository = verificationTokenRepository;
    }

    public String createVerificationToken(User user) {
        String token = UUID.randomUUID().toString();
        VerificationToken verificationToken = new VerificationToken(token, user);
        verificationTokenRepository.save(verificationToken);
        return token;
    }
}
