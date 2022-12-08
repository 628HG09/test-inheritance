package com.example.relations.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity public class Passagier extends User {
//    @Id
//    @GeneratedValue
//    @Column(name = "passagier_id")
//    Long id;

    @Column(name = "ritverzoek")
    private String ritVerzoek;

    public String getRitVerzoek() {
        return ritVerzoek;
    }

    public void setRitVerzoek(String ritVerzoek) {
        this.ritVerzoek = ritVerzoek;
    }
}
