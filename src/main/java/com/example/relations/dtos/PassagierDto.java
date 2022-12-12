package com.example.relations.dtos;

import com.example.relations.models.UserClass;

import javax.persistence.Column;
import javax.persistence.ManyToOne;

public class PassagierDto {
    private Long id;
    private String ritVerzoek;
    private UserClassDto userClassDto;

    public PassagierDto() {
    }

    public PassagierDto(Long id, String ritVerzoek) {
        this.id = id;
        this.ritVerzoek = ritVerzoek;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRitVerzoek() {
        return ritVerzoek;
    }

    public void setRitVerzoek(String ritVerzoek) {
        this.ritVerzoek = ritVerzoek;
    }

    public UserClassDto getUserClassDto() {
        return userClassDto;
    }

    public void setUserClassDto(UserClassDto userClassDto) {
        this.userClassDto = userClassDto;
    }
}
