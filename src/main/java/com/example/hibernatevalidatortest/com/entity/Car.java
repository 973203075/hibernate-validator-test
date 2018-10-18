package com.example.hibernatevalidatortest.com.entity;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Car {

    @NotBlank
    private String name;
    @Range(min = 1, max = 100)
    private int age;
    @NotBlank
    @Email
    private String mail;

    private List<@Valid String> parts = new ArrayList<>();

    public void addPart(String part) {
        parts.add( part );
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
