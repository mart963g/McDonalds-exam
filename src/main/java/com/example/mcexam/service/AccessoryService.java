package com.example.mcexam.service;

import com.example.mcexam.model.Accessory;
import com.example.mcexam.repository.AccessoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
public class AccessoryService {

    @Autowired
    AccessoryRepository accessoryRepository;

    public List<Accessory> findAll() {
        return accessoryRepository.findAll();

    }

    public Accessory findOne(Long id) {
        Accessory accessory = accessoryRepository.findById(id)
                .orElseThrow(this::badRequest);
        return accessory;
    }

    public Accessory save(Accessory accessory)
    {
        return accessoryRepository.save(accessory);
    }

    public Accessory update(Accessory accessory, Long id) {
        Accessory dbAccessory = findOne(id);
        dbAccessory.setName(accessory.getName());
        dbAccessory.setPrice(accessory.getPrice());
        dbAccessory.setSize(accessory.getSize());
        return accessoryRepository.save(dbAccessory);
    }
    public void delete(Long id) {
        Accessory dbAccessory = findOne(id);
        accessoryRepository.delete(dbAccessory);
    }

    private ResponseStatusException badRequest() {
        return new ResponseStatusException(BAD_REQUEST, "Id doesn't exist");
    }

}
