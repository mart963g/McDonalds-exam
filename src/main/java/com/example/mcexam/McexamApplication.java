package com.example.mcexam;

import com.example.mcexam.model.Accessory;
import com.example.mcexam.model.Burger;
import com.example.mcexam.model.Drink;
import com.example.mcexam.repository.AccessoryRepository;
import com.example.mcexam.repository.BurgerRepository;
import com.example.mcexam.repository.DrinkRepository;
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
    public CommandLineRunner fillTestData(BurgerRepository burgerRepository, DrinkRepository drinkRepository,
                                          AccessoryRepository accessoryRepository)
    {
        return (args) -> {
            //Burgers
            burgerRepository.save(new Burger("BigMac",19.99));
            burgerRepository.save(new Burger("Cheeseburger",10.00));
            burgerRepository.save(new Burger("McBacon",25.00));

            //Drinks
            drinkRepository.save(new Drink("Coke","Medium",15.00));
            drinkRepository.save(new Drink("Sprite","Large", 20.00));
            drinkRepository.save(new Drink("Strawberry Milkshake","Small",14.99));

            //Accessories
            accessoryRepository.save(new Accessory("Fries","Small",14.99));
            accessoryRepository.save(new Accessory("Curly fries","Big", 20.00));
            accessoryRepository.save(new Accessory("Chilli cheese tops","Big",24.99));
        };
    }

}
