package com.example.relations.controllers;

import com.example.relations.dtos.RitDto;
import com.example.relations.models.Rit;
import com.example.relations.repositories.RitRepository;
import com.example.relations.services.RitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ritten")
public class RitController {
    private final RitService ritService;

    @Autowired
    public RitController(RitService ritService) {
        this.ritService = ritService;
    }


    @PostMapping("")
    public ResponseEntity<Object>addRit(@RequestBody RitDto ritDto){
       RitDto dto = ritService.addRit(ritDto);
//        Rit savedRit =  ritService.save(ritDto);

       return ResponseEntity.created(null).body(dto);
    }
}
