package com.example.relations.controllers;

import com.example.relations.dtos.BestuurderDto;
import com.example.relations.dtos.IdInputDto;
import com.example.relations.dtos.UserClassDto;
import com.example.relations.services.UserClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserClassController {

    private final UserClassService userClassService;

    @Autowired

    public UserClassController(UserClassService userClassService) {
        this.userClassService = userClassService;
    }

//    vanaf hier invullen. Even afwachten of de user dit wel moet opvragen
    @GetMapping("/userclassen/{id}")
    public ResponseEntity<UserClassDto> getUserClass(@PathVariable("id")Long id) {

        UserClassDto userClass = userClassService.getUserClassById(id);

        return ResponseEntity.ok().body(userClass);

    }

    @PostMapping("/userclassen")
    public ResponseEntity<Object> addUserClass(@RequestBody UserClassDto userClassDto) {

        UserClassDto dto = userClassService.addUserClass(userClassDto);

        return ResponseEntity.created(null).body(dto);

    }

    @DeleteMapping("/userclassen/{id}")
    public ResponseEntity<Object> deleteUserClass(@PathVariable Long id) {

        userClassService.deleteUserClass(id);

        return ResponseEntity.noContent().build();

    }

    @PutMapping("/userclassen/{id}")
    public ResponseEntity<Object> updateUserClass(@PathVariable Long id, @RequestBody UserClassDto newUserClass) {

        UserClassDto dto = userClassService.updateUserClass(id, newUserClass);

        return ResponseEntity.ok().body(dto);
    }
    //Voor de koppeling InputDto nodig!
//    @PutMapping("/userclassen/{id}/voertuig")
//    public void assignVoertuigToBestuurder(@PathVariable("id") Long id, @RequestBody IdInputDto input) {
//        userClassService.assignVoertuigToUserClass(id, input.id);
//    }
}

