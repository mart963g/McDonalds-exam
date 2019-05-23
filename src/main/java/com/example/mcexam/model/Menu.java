package com.example.mcexam.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Menu
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String size;
    @ManyToOne(cascade = CascadeType.MERGE)
    @NotNull
    private Burger burger;
    @ManyToOne(cascade = CascadeType.MERGE)
    @NotNull
    private Drink drink;
    @ManyToOne(cascade = CascadeType.MERGE)
    @NotNull
    private Accessory accessory;
    @ManyToOne(cascade = CascadeType.MERGE)
    @NotNull
    private Dessert dessert;

    private double price;

    public Menu()
    {
    }

    public Menu(String name, String size, @NotNull Burger burger, @NotNull Drink drink, @NotNull Accessory accessory, @NotNull Dessert dessert)
    {
        this.name = name;
        this.size = size;
        this.burger = burger;
        this.drink = drink;
        this.accessory = accessory;
        this.dessert = dessert;
        this.price = (burger.getPrice()+drink.getPrice()+accessory.getPrice()+dessert.getPrice())*0.75;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getSize()
    {
        return size;
    }

    public void setSize(String size)
    {
        this.size = size;
    }

    public Burger getBurger()
    {
        return burger;
    }

    public void setBurger(Burger burger)
    {
        this.burger = burger;
    }

    public Drink getDrink()
    {
        return drink;
    }

    public void setDrink(Drink drink)
    {
        this.drink = drink;
    }

    public Accessory getAccessory()
    {
        return accessory;
    }

    public void setAccessory(Accessory accessory)
    {
        this.accessory = accessory;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public Dessert getDessert()
    {
        return dessert;
    }

    public void setDessert(Dessert dessert)
    {
        this.dessert = dessert;
    }
}
