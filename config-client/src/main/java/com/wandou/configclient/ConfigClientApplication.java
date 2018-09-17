package com.wandou.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableEurekaClient
@RestController
@SpringBootApplication
public class ConfigClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApplication.class, args);
    }

    @Value("${foo}")
    String foo;

    @Value("${foo1}")
    String foo1;

    @RequestMapping(value = "/hi")
    public String hi() {
        return foo;
    }

    @RequestMapping(value = "/hi1")
    public String hi1() {
        return foo1;
    }
}
