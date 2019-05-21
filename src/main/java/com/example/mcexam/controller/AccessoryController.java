package com.example.mcexam.controller;

import com.example.mcexam.model.Accessory;
import com.example.mcexam.service.AccessoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accessory")
public class AccessoryController {
    @Autowired
    private AccessoryService accessoryService;

    @GetMapping
    public List<Accessory> findAll() {
        return accessoryService.findAll();
    }

    @GetMapping("{id}")
    public Accessory findOne(@PathVariable Long id) {
        return accessoryService.findOne(id);
    }

    @PostMapping
    public Accessory save(@RequestBody Accessory accessory) {
        return accessoryService.save(accessory);
    }

    @PutMapping("{id}")
    public Accessory update(@RequestBody Accessory accessory, @PathVariable Long id) {
        return accessoryService.update(accessory, id);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        accessoryService.delete(id);
    }
}
