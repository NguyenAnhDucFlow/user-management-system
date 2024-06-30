package com.anhduc.backend.event;

import com.anhduc.backend.entity.User;
import com.anhduc.backend.service.EmailService;
import com.anhduc.backend.service.VerificationTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class UserRegistrationListener implements ApplicationListener<OnUserRegistrationCompleteEvent> {

    private final EmailService emailService;
    private final VerificationTokenService verificationTokenService;

    @Autowired
    public UserRegistrationListener(final EmailService emailService, final VerificationTokenService verificationTokenService) {
        this.emailService = emailService;
        this.verificationTokenService = verificationTokenService;
    }

    @Override
    public void onApplicationEvent(OnUserRegistrationCompleteEvent event) {
        this.confirmRegistration(event);
    }

    private void confirmRegistration(OnUserRegistrationCompleteEvent event) {
        User user = event.getUser();
        String token = verificationTokenService.createVerificationToken(user);
        String recipientAddress = user.getEmail();
        String subject = "Registration Confirmation";
        String confirmationUrl = event.getAppUrl() + "/registrationConfirm?token=" + token;
        String message = "Please confirm your registration by clicking the link below";
        emailService.sendMail(recipientAddress, subject, message);
    }
}
