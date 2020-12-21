package com.mycompany.eshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class eshopApplication {

    public static void main(String[] args) {
        SpringApplication.run(eshopApplication.class, args);
    }

}
