package com.example.mcexam.service;


import com.example.mcexam.repository.BurgerRepository;
import com.example.mcexam.repository.DrinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BurgerService {
    @Autowired
    private BurgerRepository burgerRepository;
    @Autowired
    private DrinkRepository drinkRepository;

/*
    public List<Burger> findAll(String modelNr, Integer yearOlder) {
        return findAllInner(modelNr, yearOlder);

    }


    private List<Burger> findAllInner(String modelNr, Integer yearOlder) {
        if (StringUtils.isNotBlank(modelNr)) {
            if (yearOlder != null) {
                return burgerRepository.findCarByModelNrAndYearOlder(modelNr, yearOlder);
            }
            return burgerRepository.findByModelNrContainingIgnoreCase(modelNr);
        }
        return burgerRepository.findAll();
    }

    public Burger findOne(Long id) {
      //  Burger burger = burgerRepository.findById(id)
       //         .orElseThrow(this::badRequest);
        //List<Drink> leases = drinkRepository.findByCar(burger);
        //burger.setDrinks(leases);
        return burger;
    }


    public Burger save(Burger burger) {
       // carValidator.validate(burger);
        burger.setCreatedAt(LocalDateTime.now());
        return burgerRepository.save(burger);
    }
    public Burger update(Burger burger, Long id) {
       // carValidator.validate(burger);
        Burger dbBurger = findOne(id);
        dbBurger.setModelNr(burger.getModelNr());
        dbBurger.setRegistrationNr(burger.getRegistrationNr());
        dbBurger.setYear(burger.getYear());
        dbBurger.setUpdatedAt(LocalDateTime.now());
        return burgerRepository.save(dbBurger);
    }
    public void delete(Long id) {
        Burger dbBurger = findOne(id);
        burgerRepository.delete(dbBurger);
    }

    */
}