package com.example.relations.controllers;

import com.example.relations.dtos.BestuurderDto;
import com.example.relations.dtos.IdInputDto;
import com.example.relations.dtos.PassagierDto;
import com.example.relations.services.PassagierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PassagierController {

    private final PassagierService passagierService;

    @Autowired
    public PassagierController(PassagierService passagierService) {
        this.passagierService = passagierService;
    }

    @GetMapping("/passagiers/{id}")
    public ResponseEntity<PassagierDto> getPassagier(@PathVariable("id")Long id) {

        PassagierDto passagier = passagierService.getPassagierById(id);

        return ResponseEntity.ok().body(passagier);

    }

    @PostMapping("/passagiers")
    public ResponseEntity<Object> addPassagier(@RequestBody PassagierDto passagierDto) {

        PassagierDto dto = passagierService.addPassagier(passagierDto);

        return ResponseEntity.created(null).body(dto);

    }

    @DeleteMapping("/passagiers/{id}")
    public ResponseEntity<Object> deletePassagier(@PathVariable Long id) {

        passagierService.deletePassagier(id);

        return ResponseEntity.noContent().build();

    }

    @PutMapping("/passagiers/{id}")
    public ResponseEntity<Object> updatePassagier(@PathVariable Long id, @RequestBody PassagierDto newPassagier) {

        PassagierDto dto = passagierService.updatePassagier(id, newPassagier);

        return ResponseEntity.ok().body(dto);
    }
    //Voor de koppeling InputDto nodig!
//    @PutMapping("/passagiers/{id}/voertuig")
//    public void assignVoertuigToBestuurder(@PathVariable("id") Long id, @RequestBody IdInputDto input) {
//        passagierService.assignVoertuigToBestuurder(id, input.id);
//    }
}