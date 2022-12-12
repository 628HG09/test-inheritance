package com.example.relations.dtos;

public class BestuurderDto {
    Long id;

    private String extraKenmerk;
//deze
    private VoertuigDto voertuigDto;

    public BestuurderDto() {
    }

    public BestuurderDto(Long id, String extraKenmerk) {
        this.id = id;
        this.extraKenmerk = extraKenmerk;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExtraKenmerk() {
        return extraKenmerk;
    }

    public void setExtraKenmerk(String extraKenmerk) {
        this.extraKenmerk = extraKenmerk;
    }

    public VoertuigDto getVoertuigDto() {
        return voertuigDto;
    }

    public void setVoertuigDto(VoertuigDto voertuigDto) {
        this.voertuigDto = voertuigDto;
    }
}
