package com.example.mcexam.service;

import com.example.mcexam.model.Menu;
import com.example.mcexam.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
public class MenuService
{
    @Autowired
    MenuRepository menuRepository;

    public List<Menu> findAll()
    {
        return menuRepository.findAll();
    }

    public Menu findOne(Long id) {
        Menu menu = menuRepository.findById(id)
                .orElseThrow(this::badRequest);
        return menu;
    }

    public Menu save(Menu menu)
    {
        return menuRepository.save(menu);
    }

    public Menu update(Menu menu, Long id) {
        Menu dbMenu = findOne(id);
        dbMenu.setName(menu.getName());
        dbMenu.setSize(menu.getSize());
        dbMenu.setBurger(menu.getBurger());
        dbMenu.setDrink(menu.getDrink());
        dbMenu.setAccessory(menu.getAccessory());
        dbMenu.setPrice(menu.getPrice());
        return menuRepository.save(dbMenu);
    }
    public void delete(Long id) {
        Menu dbMenu = findOne(id);
        menuRepository.delete(dbMenu);
    }

    private ResponseStatusException badRequest() {
        return new ResponseStatusException(BAD_REQUEST, "Id doesn't exist");
    }
}
