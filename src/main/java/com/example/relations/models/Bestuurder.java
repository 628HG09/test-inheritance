package com.example.relations.models;

import javax.persistence.*;
import java.util.List;

@Entity public class Bestuurder {
    @Id
    @GeneratedValue
    Long id;

    //  variable declaraties
    private String voornaam;
    private String achternaam;

    @OneToOne
    Voertuig voertuig;

    @OneToMany(mappedBy = "bestuurder")
    List<Rit>ritten;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public Voertuig getVoertuig() {
        return voertuig;
    }

    public void setVoertuig(Voertuig voertuig) {
        this.voertuig = voertuig;
    }

    public List<Rit> getRitten() {
        return ritten;
    }
//
//    public void setRitten(List<Rit> ritten) {
//        this.ritten = ritten;
//    }
}
