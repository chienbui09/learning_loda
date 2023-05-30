package com.example;

import org.springframework.context.ApplicationEvent;

import java.time.Clock;

public class DoorBellEvent extends ApplicationEvent {
    public String guestName;
    public DoorBellEvent(Object source,String guestName) {
        super(source);
        this.guestName = guestName;
    }

    public DoorBellEvent(Object source, Clock clock) {
        super(source, clock);
    }
}
