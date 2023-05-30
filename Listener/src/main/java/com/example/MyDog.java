package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class MyDog {

    @EventListener
    public void DoorBellEventListener(DoorBellEvent doorBellEvent) throws InterruptedException{

        // giả sử con chó đang ngủ, 1s sau mới tỉnh
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName() + ": wakeup");
        System.out.println("có khách::" + doorBellEvent.guestName);
    }
}
