package com.example.relations.services;

import com.example.relations.dtos.VoertuigDto;
import com.example.relations.models.Voertuig;
import com.example.relations.repositories.VoertuigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VoertuigService {

    @Autowired
    private VoertuigRepository voertuigRepository;

    public List<VoertuigDto> getAllVoertuigen() {
        List<VoertuigDto> dtos = new ArrayList<>();
        List<Voertuig> remoteControllers = voertuigRepository.findAll();
        for (Voertuig rc : remoteControllers) {
            dtos.add(transferToDto(rc));
        }
        return dtos;
    }

    public VoertuigDto addVoertuig(VoertuigDto voertuigDto) {
        Voertuig rc =  transferToVoertuig(voertuigDto);
        voertuigRepository.save(rc);
        return voertuigDto;
    }

    public VoertuigDto transferToDto(Voertuig voertuig){
        var dto = new VoertuigDto();

        dto.id = voertuig.getId();
        dto.merk = voertuig.getMerk();
        dto.model = voertuig.getModel();

        return dto;
    }

    public Voertuig transferToVoertuig(VoertuigDto dto){
        var voertuig = new Voertuig();

        voertuig.setId(dto.getId());
        voertuig.setMerk(dto.getMerk());
        voertuig.setModel(dto.getModel());

        return voertuig;
    }

}
