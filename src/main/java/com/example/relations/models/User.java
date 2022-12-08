package com.example.relations.models;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Inheritance
@Entity
@Table(name = "user_table")
public abstract class User {
    @Id
//    @GeneratedValue
    private Long id;

    //  variable declaraties
    @NotNull
    @Column
    public String gebruikersnaam;
    public String wachtwoord;
    public String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGebruikersnaam() {
        return gebruikersnaam;
    }

    public void setGebruikersnaam(String gebruikersnaam) {
        this.gebruikersnaam = gebruikersnaam;
    }

    public String getWachtwoord() {
        return wachtwoord;
    }

    public void setWachtwoord(String wachtwoord) {
        this.wachtwoord = wachtwoord;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
