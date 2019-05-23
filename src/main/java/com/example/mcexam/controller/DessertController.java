package com.example.mcexam.controller;

import com.example.mcexam.model.Dessert;
import com.example.mcexam.service.DessertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dessert")
public class DessertController
{
    @Autowired
    private DessertService dessertService;

    @GetMapping
    public List<Dessert> findAll() {
        return dessertService.findAll();
    }

    @GetMapping("{id}")
    public Dessert findOne(@PathVariable Long id) {
        return dessertService.findOne(id);
    }

    @PostMapping
    public Dessert save(@RequestBody Dessert dessert) {
        return dessertService.save(dessert);
    }

    @PutMapping("{id}")
    public Dessert update(@RequestBody Dessert dessert, @PathVariable Long id) {
        return dessertService.update(dessert, id);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        dessertService.delete(id);
    }
}
