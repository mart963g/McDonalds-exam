package com.example.mcexam;

import com.example.mcexam.model.Burger;
import com.example.mcexam.repository.BurgerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class McexamApplication {

    public static void main(String[] args) {
        SpringApplication.run(McexamApplication.class, args);
    }

    @Bean
    public CommandLineRunner fillTestData(BurgerRepository burgerRepository)
    {
        return (args) -> {
            burgerRepository.save(new Burger("BigMac",19.99));
        };
    }

}
