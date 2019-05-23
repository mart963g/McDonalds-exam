package com.example.mcexam;

import com.example.mcexam.model.*;
import com.example.mcexam.repository.*;
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
                                          AccessoryRepository accessoryRepository, MenuRepository menuRepository,
                                          DessertRepository dessertRepository)
    {
        return (args) -> {
            //Burgers
            Burger bigMac = burgerRepository.save(new Burger("BigMac",19.99));
            burgerRepository.save(new Burger("Cheeseburger",10.00));
            burgerRepository.save(new Burger("McBacon",25.00));

            //Drinks
            Drink mCoke = drinkRepository.save(new Drink("Coke","Medium",15.00));
            drinkRepository.save(new Drink("Sprite","Large", 20.00));
            drinkRepository.save(new Drink("Strawberry Milkshake","Small",14.99));

            //Accessories
            Accessory fries = accessoryRepository.save(new Accessory("Fries","Medium",14.99));
            accessoryRepository.save(new Accessory("Curly fries","Big", 20.00));
            accessoryRepository.save(new Accessory("Chilli cheese tops","Big",24.99));

            //Desserts
            Dessert dessert = dessertRepository.save(new Dessert("McFlurry Oreo",15.00));
            dessertRepository.save(new Dessert("McFlurry Twix",15.00));
            dessertRepository.save(new Dessert("Blueberry Muffin",20.00));

            //Menus
            menuRepository.save(new Menu("BigMac Menu","Medium",bigMac,mCoke,fries,dessert));
        };
    }

}
