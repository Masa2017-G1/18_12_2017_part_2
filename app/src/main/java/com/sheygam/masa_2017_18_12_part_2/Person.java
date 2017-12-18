package com.sheygam.masa_2017_18_12_part_2;

import java.io.Serializable;

/**
 * Created by gregorysheygam on 18/12/2017.
 */

public class Person implements Serializable{
    private String name, email, phone;

    public Person(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
