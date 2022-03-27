package com.example.myapplication;

public class Dish{
    private int id;
    private int dishImage;
    private String dishType;
    private String dishName;
    private String dishCost;

    public Dish(int id, int dishImage, String dishType, String dishName, String dishCost) {
        this.id = id;
        this.dishImage = dishImage;
        this.dishType = dishType;
        this.dishName = dishName;
        this.dishCost = dishCost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDishImage() {
        return dishImage;
    }

    public void setDishImage(int dishImage) {
        this.dishImage = dishImage;
    }

    public String getDishType() {
        return dishType;
    }

    public void setDishType(String dishType) {
        this.dishType = dishType;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getDishCost() {
        return dishCost;
    }

    public void setDishCost(String dishCost) {
        this.dishCost = dishCost;
    }
}
