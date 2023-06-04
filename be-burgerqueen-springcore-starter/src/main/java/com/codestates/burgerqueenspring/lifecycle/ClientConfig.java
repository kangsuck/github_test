package com.codestates.burgerqueenspring.lifecycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClientConfig {
    @Bean(initMethod = "init", destroyMethod = "close")
    public TestClient testClient() {
        TestClient testClient = new TestClient("www.codestates.com");
        return testClient;
    }
}
