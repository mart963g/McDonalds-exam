package com.example.mcexam.controller;
import com.example.mcexam.model.Drink;
import com.example.mcexam.service.DrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/drink")
public class DrinkController {
    @Autowired
    private DrinkService drinkService;

    @GetMapping
    public List<Drink> findAll() {
        return drinkService.findAll();
    }

    @GetMapping("{id}")
    public Drink findOne(@PathVariable Long id) {
        return drinkService.findOne(id);
    }

    @PostMapping
    public Drink save(@RequestBody Drink drink) {
        return drinkService.save(drink);
    }

    @PutMapping("{id}")
    public Drink update(@RequestBody Drink drink, @PathVariable Long id) {
        return drinkService.update(drink, id);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        drinkService.delete(id);
    }
}