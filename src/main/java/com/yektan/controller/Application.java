package com.yektan.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by yektan on 1.01.2018.
 *
 * Spring Boot'u yapılandıran sınıfım.
 *
 */

@SpringBootApplication
@EnableJpaAuditing // JPA denetlemesi
@EnableJpaRepositories("com.yektan.repository") // JpaRepository sınıflarını tarar.
@EntityScan("com/yektan/model") // Modelleri tarar.
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
