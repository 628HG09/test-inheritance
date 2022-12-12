package com.example.relations.services;

import com.example.relations.dtos.BestuurderDto;
import com.example.relations.dtos.UserClassDto;
import com.example.relations.exceptions.RecordNotFoundException;
import com.example.relations.models.Bestuurder;
import com.example.relations.models.UserClass;
import com.example.relations.repositories.UserClassRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserClassService {

    private final UserClassRepository userClassRepository;

    public UserClassService(UserClassRepository userClassRepository) {
        this.userClassRepository = userClassRepository;
    }

    public List<UserClassDto> getAllUserclassen() {
        List<UserClass> tvList = userClassRepository.findAll();
        return transferUserClassListToDtoList(tvList);
    }

//    public List<BestuurderDto> getAllBestuurdersByAchternaam(String achternaam) {
//        List<Bestuurder> tvList = bestuurderRepository.findAllBestuurdersByAchternaamEqualsIgnoreCase(achternaam);
//        return transferBestuurderListToDtoList(tvList);
//    }

    public UserClassDto getUserClassById(Long id) {

        if (userClassRepository.findById(id).isPresent()){
            UserClass tv = userClassRepository.findById(id).get();
            UserClassDto dto =transferToDto(tv);
//            if(tv.getCiModule() != null){
//                dto.setCiModuleDto(ciModuleService.transferToDto(tv.getCiModule()));
//            }
//            if(tv.getVoertuig() != null){
//                dto.setVoertuigDto(voertuigService.transferToDto(tv.getVoertuig()));
//            }

            return transferToDto(tv);
        } else {
            throw new RecordNotFoundException("geen user gevonden");
        }
    }

    public UserClassDto addUserClass(UserClassDto dto) {

        UserClass tv = transferToUserClass(dto);
        userClassRepository.save(tv);

        return transferToDto(tv);
    }

    public void deleteUserClass(@RequestBody Long id) {

        userClassRepository.deleteById(id);
    }


    public UserClass transferToUserClass(UserClassDto dto){
        var userClass = new UserClass();

        userClass.setVoornaam(dto.getVoornaam());
        userClass.setAchternaam(dto.getAchternaam());
        userClass.setGebruikersnaam(dto.getGebruikersnaam());
        userClass.setWachtwoord(dto.getWachtwoord());
        userClass.setEmail(dto.getEmail());

        return userClass;
    }
    public UserClassDto updateUserClass(Long id, UserClassDto inputDto) {

        if (userClassRepository.findById(id).isPresent()){

            UserClass tv = userClassRepository.findById(id).get();

            UserClass tv1 = transferToUserClass(inputDto);
            tv1.setId(tv.getId());

            userClassRepository.save(tv1);

            return transferToDto(tv1);

        } else {

            throw new  RecordNotFoundException("geen user gevonden");

        }

    }


    public static UserClassDto transferToDto(UserClass userClass){
        UserClassDto dto = new UserClassDto();

        dto.setId(userClass.getId());
        dto.setVoornaam(userClass.getVoornaam());
        dto.setAchternaam(userClass.getAchternaam());
        dto.setGebruikersnaam(userClass.getGebruikersnaam());
        dto.setWachtwoord(userClass.getWachtwoord());
        dto.setEmail(userClass.getEmail());

//        if(bestuurder.getCiModule() != null){
//            dto.setCiModuleDto(CIModuleService.transferToDto(bestuurder.getCiModule()));
//        }

        return dto;
    }
    public List<UserClassDto> transferUserClassListToDtoList(List<UserClass> userClassen){
        List<UserClassDto> tvDtoList = new ArrayList<>();

        for(UserClass tv : userClassen) {
            UserClassDto dto = transferToDto(tv);
//            if(tv.getCiModule() != null){
//                dto.setCiModuleDto(ciModuleService.transferToDto(tv.getCiModule()));
//            }
//            if(tv.getVoertuig() != null){
//                dto.setVoertuigDto(voertuigService.transferToDto(tv.getVoertuig()));
//            }
            tvDtoList.add(dto);
        }
        return tvDtoList;
    }
//    public void assignVoertuigToUserClass(Long id, Long voertuigId) {
//        var optionalUserClass = userClassRepository.findById(id);
//        var optionalVoertuig = voertuigRepository.findById(voertuigId);
//
//        if(optionalUserClass.isPresent() && optionalVoertuig.isPresent()) {
//            var userClass = optionalUserClass.get();
//            var voertuig = optionalVoertuig.get();
//
//            userClass.setVoertuig(voertuig);
//            userClassRepository.save(userClass);
//        } else {
//            throw new RecordNotFoundException();
//        }
//    }
}

