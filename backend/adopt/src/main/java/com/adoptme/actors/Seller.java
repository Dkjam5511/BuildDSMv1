package com.adoptme.actors;

public class Seller extends Account{

    private String role;
    private String reviews;
    
    public Seller(String name, String email, String phone, String address, String city, String state, String zip, String country, String password, String role, String reviews){
        super(name, email, phone, address, city, state, zip, country, password);
        this.role = role;
        this.reviews = reviews;
    }

}