package com.anhduc.backend.event;

import com.anhduc.backend.entity.User;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class OnUserRegistrationCompleteEvent extends ApplicationEvent {

    private final User user;
    private final String appUrl;

    public OnUserRegistrationCompleteEvent(User user, String appUrl) {
        super(user);
        this.user = user;
        this.appUrl = appUrl;
    }
}
