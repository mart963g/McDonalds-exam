package com.example.mcexam.service;

import com.example.mcexam.model.Drink;
import com.example.mcexam.repository.DrinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
public class DrinkService {

    @Autowired
    DrinkRepository drinkRepository;

    public List<Drink> findAll() {
        return drinkRepository.findAll();

    }

    public Drink findOne(Long id) {
        Drink drink = drinkRepository.findById(id)
                .orElseThrow(this::badRequest);
        return drink;
    }

    public Drink save(Drink drink)
    {
        return drinkRepository.save(drink);
    }

    public Drink update(Drink drink, Long id) {
        Drink dbDrink = findOne(id);
        dbDrink.setName(drink.getName());
        dbDrink.setPrice(drink.getPrice());
        dbDrink.setSize(drink.getSize());
        return drinkRepository.save(dbDrink);
    }
    public void delete(Long id) {
        Drink dbDrink = findOne(id);
        drinkRepository.delete(dbDrink);
    }

    private ResponseStatusException badRequest() {
        return new ResponseStatusException(BAD_REQUEST, "Id doesn't exist");
    }
}
