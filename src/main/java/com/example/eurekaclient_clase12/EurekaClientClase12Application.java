package com.example.eurekaclient_clase12;

import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class EurekaClientClase12Application {
    @Autowired
    @Lazy
    private EurekaClient eurekaClient;

    @Value("EurekaClient_Clase12_Hello")
    private String appName;

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientClase12Application.class, args);
    }

    @GetMapping("/greeting")
    public String greeting(){
        return String.format("Hello from '%s'!",
                eurekaClient.getApplication(appName).getName());
    }
}
