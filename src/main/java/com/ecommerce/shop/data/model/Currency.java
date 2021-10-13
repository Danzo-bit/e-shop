package com.ecommerce.shop.data.model;

public enum Currency {
    NGN("Naira"), USD("Dollar"), SRC("Singapore Dollar"), GBP("British Pounds"), FRC("Franc"), GHC("Ghana Cedis");

    private String name;
    Currency(String currencyName) {
        this.name = currencyName;
    }

    private String getName(){
        return  name;
    }
}
