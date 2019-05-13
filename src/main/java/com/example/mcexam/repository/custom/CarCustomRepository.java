package com.example.mcexam.repository.custom;



import com.example.mcexam.model.Burger;

import java.util.List;

public interface CarCustomRepository {

    List<Burger> findCarByModelNrAndYearOlder(String modelNr, Integer year);

}