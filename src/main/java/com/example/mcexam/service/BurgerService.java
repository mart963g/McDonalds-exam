package com.example.mcexam.service;


import com.example.mcexam.model.Burger;
import com.example.mcexam.repository.BurgerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;


import java.util.List;

@Service
public class BurgerService {
    @Autowired
    private BurgerRepository burgerRepository;


    public List<Burger> findAll() {
        return burgerRepository.findAll();

    }

    public Burger findOne(Long id) {
        Burger burger = burgerRepository.findById(id)
                .orElseThrow(this::badRequest);
        return burger;
    }

    public Burger save(Burger burger)
    {
        return burgerRepository.save(burger);
    }

    public Burger update(Burger burger, Long id) {
        Burger dbBurger = findOne(id);
        dbBurger.setName(burger.getName());
        dbBurger.setPrice(burger.getPrice());
        return burgerRepository.save(dbBurger);
    }
    public void delete(Long id) {
        Burger dbBurger = findOne(id);
        burgerRepository.delete(dbBurger);
    }

    private ResponseStatusException badRequest() {
        return new ResponseStatusException(BAD_REQUEST, "Id doesn't exist");
    }
}