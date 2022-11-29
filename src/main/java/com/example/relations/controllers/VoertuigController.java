package com.example.relations.controllers;

import com.example.relations.dtos.VoertuigDto;
import com.example.relations.services.VoertuigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/voertuigen/{id}")
    public VoertuigDto updateBestuurder(@PathVariable("id") Long id, @RequestBody VoertuigDto dto) {
        voertuigService.updateVoertuig(id, dto);
        return dto;
    }



}
