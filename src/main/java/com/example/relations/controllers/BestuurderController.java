package com.example.relations.controllers;

import com.example.relations.dtos.BestuurderDto;
import com.example.relations.dtos.IdInputDto;
import com.example.relations.services.BestuurderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
public class BestuurderController {
    private final BestuurderService bestuurderService;

    @Autowired
    public BestuurderController(BestuurderService bestuurderService){
        this.bestuurderService = bestuurderService;
    }

    // bestuurder heeft geen achternaam
//    @GetMapping("/bestuurders")
//    public ResponseEntity<List<BestuurderDto>> getAllBestuurders(@RequestParam(value = "achternaam", required = false) Optional<String> achternaam) {
//
//        List<BestuurderDto> dtos;
//
//        if (achternaam.isEmpty()){
//
//            dtos = bestuurderService.getAllBestuurders();
//
//        }
//        else {
//
//            dtos = bestuurderService.getAllBestuurdersByAchternaam(achternaam.get());
//
//        }
//
//        return ResponseEntity.ok().body(dtos);
//
//    }

    @GetMapping("/bestuurders/{id}")
    public ResponseEntity<BestuurderDto> getBestuurder(@PathVariable("id")Long id) {

        BestuurderDto bestuurder = bestuurderService.getBestuurderById(id);

        return ResponseEntity.ok().body(bestuurder);

    }

    @PostMapping("/bestuurders")
    public ResponseEntity<Object> addBestuurder(@RequestBody BestuurderDto bestuurderDto) {

        BestuurderDto dto = bestuurderService.addBestuurder(bestuurderDto);

        return ResponseEntity.created(null).body(dto);

    }

    @DeleteMapping("/bestuurders/{id}")
    public ResponseEntity<Object> deleteBestuurder(@PathVariable Long id) {

        bestuurderService.deleteBestuurder(id);

        return ResponseEntity.noContent().build();

    }

    @PutMapping("/bestuurders/{id}")
    public ResponseEntity<Object> updateBestuurder(@PathVariable Long id, @RequestBody BestuurderDto newBestuurder) {

        BestuurderDto dto = bestuurderService.updateBestuurder(id, newBestuurder);

        return ResponseEntity.ok().body(dto);
    }
//Voor de koppeling InputDto nodig!
    @PutMapping("/bestuurders/{id}/voertuig")
    public void assignVoertuigToBestuurder(@PathVariable("id") Long id, @RequestBody IdInputDto input) {
        bestuurderService.assignVoertuigToBestuurder(id, input.id);
    }



}
