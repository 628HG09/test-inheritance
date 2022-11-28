package com.example.relations.dtos;

public class VoertuigDto {
    public Long id;
    public String merk;
    public String model;

    public VoertuigDto() {
    }

    public VoertuigDto(Long id, String merk, String model) {
        this.id = id;
        this.merk = merk;
        this.model = model;
    }

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
}
