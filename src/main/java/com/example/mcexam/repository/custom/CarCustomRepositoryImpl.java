package com.example.mcexam.repository.custom;


import com.example.mcexam.model.Burger;

import javax.persistence.*;
import java.util.List;

public class CarCustomRepositoryImpl implements CarCustomRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Burger> findCarByModelNrAndYearOlder(String modelNr, Integer year) {
        List<Burger> list = entityManager.createQuery("" +
               // "SELECT c from Car c " +
                "WHERE lower(c.modelNr) like :modelNr " +
                "and c.year > :year", Burger.class)
                .setParameter("modelNr", "%" + "audi".toLowerCase() + "%")
                .setParameter("year", year)
                .getResultList();

        List<Burger> resultList = (List<Burger>) entityManager.createNativeQuery("" +
                "SELECT *\n" +
                "FROM CAR \n" +
                "WHERE lower(MODEL_NR) LIKE :modelNr \n" +
                "and year > :year", Burger.class)
                .setParameter("modelNr", "%" + "audi".toLowerCase() + "%")
                .setParameter("year", year)
                .getResultList();
        return resultList;

    }

}