package com.example.relations.services;

import com.example.relations.dtos.BestuurderDto;
import com.example.relations.dtos.PassagierDto;
import com.example.relations.exceptions.RecordNotFoundException;
import com.example.relations.models.Bestuurder;
import com.example.relations.models.Passagier;
import com.example.relations.repositories.PassagierRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class PassagierService {

    private final PassagierRepository passagierRepository;

    public PassagierService(PassagierRepository passagierRepository) {
        this.passagierRepository = passagierRepository;
    }

    public List<PassagierDto> getAllPassagiers() {
        List<Passagier> tvList = passagierRepository.findAll();
        return transferPassagierListToDtoList(tvList);
    }

//    public List<BestuurderDto> getAllBestuurdersByAchternaam(String achternaam) {
//        List<Bestuurder> tvList = bestuurderRepository.findAllBestuurdersByAchternaamEqualsIgnoreCase(achternaam);
//        return transferBestuurderListToDtoList(tvList);
//    }

    public PassagierDto getPassagierById(Long id) {

        if (passagierRepository.findById(id).isPresent()){
            Passagier tv = passagierRepository.findById(id).get();
            PassagierDto dto =transferToDto(tv);
//            if(tv.getCiModule() != null){
//                dto.setCiModuleDto(ciModuleService.transferToDto(tv.getCiModule()));
//            }
//            if(tv.getVoertuig() != null){
//                dto.setVoertuigDto(voertuigService.transferToDto(tv.getVoertuig()));
//            }

            return transferToDto(tv);
        } else {
            throw new RecordNotFoundException("geen passagier gevonden");
        }
    }

    public PassagierDto addPassagier(PassagierDto dto) {

        Passagier tv = transferToPassagier(dto);
        passagierRepository.save(tv);

        return transferToDto(tv);
    }

    public void deletePassagier(@RequestBody Long id) {

        passagierRepository.deleteById(id);
    }


    public Passagier transferToPassagier(PassagierDto dto){
        var passagier = new Passagier();

        passagier.setRitVerzoek(dto.getRitVerzoek());
//        bestuurder.setAchternaam(dto.getAchternaam());

        return passagier;
    }
    public PassagierDto updatePassagier(Long id, PassagierDto inputDto) {

        if (passagierRepository.findById(id).isPresent()){

            Passagier tv = passagierRepository.findById(id).get();

            Passagier tv1 = transferToPassagier(inputDto);
            tv1.setId(tv.getId());

            passagierRepository.save(tv1);

            return transferToDto(tv1);

        } else {

            throw new  RecordNotFoundException("geen passagier gevonden");

        }

    }


    public static PassagierDto transferToDto(Passagier passagier){
        PassagierDto dto = new PassagierDto();

        dto.setId(passagier.getId());
        dto.setRitVerzoek(passagier.getRitVerzoek());
//        dto.setAchternaam(bestuurder.getAchternaam());

//        if(bestuurder.getCiModule() != null){
//            dto.setCiModuleDto(CIModuleService.transferToDto(bestuurder.getCiModule()));
//        }

        return dto;
    }
    public List<PassagierDto> transferPassagierListToDtoList(List<Passagier>passagiers){
        List<PassagierDto> tvDtoList = new ArrayList<>();

        for(Passagier tv : passagiers) {
            PassagierDto dto = transferToDto(tv);
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
//    public void assignVoertuigToPassagier(Long id, Long voertuigId) {
//        var optionalPassagier = passagierRepository.findById(id);
//        var optionalVoertuig = voertuigRepository.findById(voertuigId);
//
//        if(optionalPassagier.isPresent() && optionalVoertuig.isPresent()) {
//            var passagier = optionalPassagier.get();
//            var voertuig = optionalVoertuig.get();
//
//            passagier.setVoertuig(voertuig);
//            passagierRepository.save(passagier);
//        } else {
//            throw new RecordNotFoundException();
//        }
//    }
}

