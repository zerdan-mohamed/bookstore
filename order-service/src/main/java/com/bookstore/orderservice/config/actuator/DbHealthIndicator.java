package com.bookstore.orderservice.config.actuator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class DbHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        if(isDBHealthy()){
            return Health.up().withDetail("External Db service ", "Healthy").build();
        }
        return Health.down().withDetail("External Db service ", "Is Not Healthy").build();
    }

    // Mimics a call to an external service or DB
    private boolean isDBHealthy(){
        Random random = new Random();
        return random.nextBoolean();
    }

}
