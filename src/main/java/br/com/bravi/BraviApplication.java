package br.com.bravi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
public class BraviApplication {

    public static void main(String[] args) {
        SpringApplication.run(BraviApplication.class, args);
    }

}
