package com.example.mcexam.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
public class BurgerController {
/*
    @Autowired
    private BurgerService burgerService;

    @GetMapping
    public List<Burger> findAll(@RequestParam(value = "modelNr", required = false) String modelNr) {
        return burgerService.findAll(modelNr,1);
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
    */
}