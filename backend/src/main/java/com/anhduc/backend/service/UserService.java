package com.anhduc.backend.service;

import com.anhduc.backend.dto.UserRegistrationDto;
import com.anhduc.backend.entity.User;
import com.anhduc.backend.event.OnUserRegistrationCompleteEvent;
import com.anhduc.backend.exception.UserAlreadyExistsException;
import com.anhduc.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final ApplicationEventPublisher eventPublisher;

    @Autowired
    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder, ApplicationEventPublisher eventPublisher) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.eventPublisher = eventPublisher;
    }

    @Transactional
    public void registerUser(UserRegistrationDto userRegistrationDto, String appUrl) {
        if (userRepository.existsByEmail(userRegistrationDto.getEmail()))
            throw new UserAlreadyExistsException("Email already in use");

        User user = new User();
        user.setUsername(userRegistrationDto.getUsername());
        user.setEmail(userRegistrationDto.getEmail());
        user.setPassword(bCryptPasswordEncoder.encode(userRegistrationDto.getPassword()));
        userRepository.save(user);
        eventPublisher.publishEvent(new OnUserRegistrationCompleteEvent(user, appUrl));
    }

}
