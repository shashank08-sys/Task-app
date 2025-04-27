package com.task.shashank.health;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheck {
    @GetMapping
    public String health(){
        return "This application is working fine";
    }
}
