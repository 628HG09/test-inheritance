package com.example.relations.controllers;

import com.example.relations.dtos.VoertuigDto;
import com.example.relations.services.VoertuigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VoertuigController {
    private final VoertuigService voertuigService;

    @Autowired
    public VoertuigController(VoertuigService voertuigService) {
        this.voertuigService = voertuigService;
    }

    @PostMapping("/voertuigen")
    public VoertuigDto addVoertuig(@RequestBody VoertuigDto dto) {
        VoertuigDto dto1 = voertuigService.addVoertuig(dto);
        return dto1;
    }
}
