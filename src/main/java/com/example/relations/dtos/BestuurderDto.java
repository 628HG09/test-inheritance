package com.example.relations.dtos;

public class BestuurderDto {
    Long id;
    private String voornaam;
    private String achternaam;

    private VoertuigDto voertuigDto;

    public BestuurderDto() {
    }

    public BestuurderDto(Long id, String voornaam, String achternaam) {
        this.id = id;
        this.voornaam = voornaam;
        this.achternaam = achternaam;
    }

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

    public VoertuigDto getVoertuigDto() {
        return voertuigDto;
    }

    public void setVoertuigDto(VoertuigDto voertuigDto) {
        this.voertuigDto = voertuigDto;
    }
}
