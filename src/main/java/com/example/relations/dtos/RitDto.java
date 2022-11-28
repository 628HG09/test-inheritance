package com.example.relations.dtos;

public class RitDto {
    private Long id;
    private String ophaalLocatie;
    private String bestemming;

    private BestuurderDto bestuurderDto;

    public RitDto() {
    }

    public RitDto(Long id, String ophaalLocatie, String bestemming) {
        this.id = id;
        this.ophaalLocatie = ophaalLocatie;
        this.bestemming = bestemming;
    }

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

    public BestuurderDto getBestuurderDto() {
        return bestuurderDto;
    }

    public void setBestuurderDto(BestuurderDto bestuurderDto) {
        this.bestuurderDto = bestuurderDto;
    }
}
