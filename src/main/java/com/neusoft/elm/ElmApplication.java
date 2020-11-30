package com.neusoft.elm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * @author QiutianDog
 */
@SpringBootApplication
public class ElmApplication {

    public static void main(String[] args) {
        SpringApplication.run(ElmApplication.class, args);
    }

}
