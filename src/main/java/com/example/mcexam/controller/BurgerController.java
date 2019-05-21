package com.example.mcexam.controller;


import com.example.mcexam.model.Burger;
import com.example.mcexam.service.BurgerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/burger")
public class BurgerController {

    @Autowired
    private BurgerService burgerService;

    @GetMapping
    public List<Burger> findAll() {
        return burgerService.findAll();
    }

    @GetMapping("{id}")
    public Burger findOne(@PathVariable Long id) {
        return burgerService.findOne(id);
    }

    @PostMapping
    public Burger save(@RequestBody Burger burger) {
        return burgerService.save(burger);
    }

    @PutMapping("{id}")
    public Burger update(@RequestBody Burger burger, @PathVariable Long id) {
        return burgerService.update(burger, id);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        burgerService.delete(id);
    }

}