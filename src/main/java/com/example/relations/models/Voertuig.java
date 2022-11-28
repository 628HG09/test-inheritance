package com.example.relations.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Voertuig {
    @Id
    @GeneratedValue
    private Long id;

    private String merk;
    private String model;

    @OneToOne(mappedBy = "voertuig")
    Bestuurder bestuurder;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Bestuurder getBestuurder() {
        return bestuurder;
    }

    public void setBestuurder(Bestuurder bestuurder) {
        this.bestuurder = bestuurder;
    }
}
