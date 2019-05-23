package com.example.mcexam.service;

import com.example.mcexam.model.Dessert;
import com.example.mcexam.repository.DessertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
public class DessertService
{
    @Autowired
    DessertRepository dessertRepository;

    public List<Dessert> findAll() {
        return dessertRepository.findAll();

    }

    public Dessert findOne(Long id) {
        Dessert dessert = dessertRepository.findById(id)
                .orElseThrow(this::badRequest);
        return dessert;
    }

    public Dessert save(Dessert dessert)
    {
        return dessertRepository.save(dessert);
    }

    public Dessert update(Dessert dessert, Long id) {
        Dessert dbDessert= findOne(id);
        dbDessert.setName(dessert.getName());
        dbDessert.setPrice(dessert.getPrice());
        return dessertRepository.save(dbDessert);
    }
    public void delete(Long id) {
        Dessert dbDessert = findOne(id);
        dessertRepository.delete(dbDessert);
    }

    private ResponseStatusException badRequest() {
        return new ResponseStatusException(BAD_REQUEST, "Id doesn't exist");
    }
}
