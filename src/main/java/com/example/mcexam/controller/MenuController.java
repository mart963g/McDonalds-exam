package com.example.mcexam.controller;

import com.example.mcexam.model.Menu;
import com.example.mcexam.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController
{
    @Autowired
    private MenuService menuService;

    @GetMapping
    public List<Menu> findAll() {
        return menuService.findAll();
    }

    @GetMapping("{id}")
    public Menu findOne(@PathVariable Long id) {
        return menuService.findOne(id);
    }

    @PostMapping
    public Menu save(@RequestBody Menu menu) {
        return menuService.save(menu);
    }

    @PutMapping("{id}")
    public Menu update(@RequestBody Menu menu, @PathVariable Long id) {
        return menuService.update(menu, id);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        menuService.delete(id);
    }
}
