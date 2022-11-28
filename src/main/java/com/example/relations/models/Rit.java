package com.example.relations.models;

import javax.persistence.*;

@Entity
@Table(name="ritten")
public class Rit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String ophaalLocatie;
    private String bestemming;

    @ManyToOne
    Bestuurder bestuurder;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOphaalLocatie() {
        return ophaalLocatie;
    }

    public void setOphaalLocatie(String ophaalLocatie) {
        this.ophaalLocatie = ophaalLocatie;
    }

    public String getBestemming() {
        return bestemming;
    }

    public void setBestemming(String bestemming) {
        this.bestemming = bestemming;
    }

    public Bestuurder getBestuurder() {
        return bestuurder;
    }

    public void setBestuurder(Bestuurder bestuurder) {
        this.bestuurder = bestuurder;
    }
}
