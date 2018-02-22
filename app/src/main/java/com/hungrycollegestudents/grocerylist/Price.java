package com.hungrycollegestudents.grocerylist;

public class Price {

    double amount;
    //TODO: add location

    public Price(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return String.valueOf(amount);
    }

}
