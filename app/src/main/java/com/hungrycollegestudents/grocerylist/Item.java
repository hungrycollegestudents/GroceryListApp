package com.hungrycollegestudents.grocerylist;

public class Item {

    private String name;
    private Price price;
    private int upc;

    public Item(String name, Price price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Price getPrice() {
        return price;
    }
}