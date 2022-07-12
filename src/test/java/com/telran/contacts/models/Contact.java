package com.telran.contacts.models;

public class Contact {
    private  String name;
    private  String lastname;
    private  String phone;
    private  String address;
    private  String city;
    private  String description;

    public Contact setName(String name) {
        this.name = name;
        return this;
    }

    public Contact setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public Contact setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public Contact setAddress(String address) {
        this.address = address;
        return this;
    }

    public Contact setCity(String city) {
        this.city = city;
        return this;
    }

    public Contact setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getDescription() {
        return description;
    }
}
