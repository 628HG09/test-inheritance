package com.example.relations.services;

import com.example.relations.dtos.BestuurderDto;
import com.example.relations.exceptions.RecordNotFoundException;
import com.example.relations.models.Bestuurder;
import com.example.relations.repositories.BestuurderRepository;
import com.example.relations.repositories.VoertuigRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class BestuurderService {
    private final BestuurderRepository bestuurderRepository;

    private final VoertuigRepository voertuigRepository;

    private  final VoertuigService voertuigService;

    public BestuurderService(BestuurderRepository bestuurderRepository, VoertuigRepository voertuigRepository, VoertuigService voertuigService) {
        this.bestuurderRepository = bestuurderRepository;
        this.voertuigRepository = voertuigRepository;
        this.voertuigService = voertuigService;
    }


    public List<BestuurderDto> getAllBestuurders() {
        List<Bestuurder> tvList = bestuurderRepository.findAll();
        return transferBestuurderListToDtoList(tvList);
    }

//    public List<BestuurderDto> getAllBestuurdersByAchternaam(String achternaam) {
//        List<Bestuurder> tvList = bestuurderRepository.findAllBestuurdersByAchternaamEqualsIgnoreCase(achternaam);
//        return transferBestuurderListToDtoList(tvList);
//    }

    public BestuurderDto getBestuurderById(Long id) {

        if (bestuurderRepository.findById(id).isPresent()){
            Bestuurder tv = bestuurderRepository.findById(id).get();
            BestuurderDto dto =transferToDto(tv);
//            if(tv.getCiModule() != null){
//                dto.setCiModuleDto(ciModuleService.transferToDto(tv.getCiModule()));
//            }
            if(tv.getVoertuig() != null){
                dto.setVoertuigDto(voertuigService.transferToDto(tv.getVoertuig()));
            }

            return transferToDto(tv);
        } else {
            throw new RecordNotFoundException("geen bestuurder gevonden");
        }
    }

    public BestuurderDto addBestuurder(BestuurderDto dto) {

        Bestuurder tv = transferToBestuurder(dto);
        bestuurderRepository.save(tv);

        return transferToDto(tv);
    }

    public void deleteBestuurder(@RequestBody Long id) {

        bestuurderRepository.deleteById(id);
    }


    public Bestuurder transferToBestuurder(BestuurderDto dto){
        var bestuurder = new Bestuurder();

        bestuurder.setExtraKenmerk(dto.getExtraKenmerk());
//        bestuurder.setAchternaam(dto.getAchternaam());

        return bestuurder;
    }
    public BestuurderDto updateBestuurder(Long id, BestuurderDto inputDto) {

        if (bestuurderRepository.findById(id).isPresent()){

            Bestuurder tv = bestuurderRepository.findById(id).get();

            Bestuurder tv1 = transferToBestuurder(inputDto);
            tv1.setId(tv.getId());

            bestuurderRepository.save(tv1);

            return transferToDto(tv1);

        } else {

            throw new  RecordNotFoundException("geen televisie gevonden");

        }

    }


    public static BestuurderDto transferToDto(Bestuurder bestuurder){
        BestuurderDto dto = new BestuurderDto();

        dto.setId(bestuurder.getId());
        dto.setExtraKenmerk(bestuurder.getExtraKenmerk());
//        dto.setAchternaam(bestuurder.getAchternaam());

//        if(bestuurder.getCiModule() != null){
//            dto.setCiModuleDto(CIModuleService.transferToDto(bestuurder.getCiModule()));
//        }

        return dto;
    }
    public List<BestuurderDto> transferBestuurderListToDtoList(List<Bestuurder> bestuurders){
        List<BestuurderDto> tvDtoList = new ArrayList<>();

        for(Bestuurder tv : bestuurders) {
            BestuurderDto dto = transferToDto(tv);
//            if(tv.getCiModule() != null){
//                dto.setCiModuleDto(ciModuleService.transferToDto(tv.getCiModule()));
//            }
            if(tv.getVoertuig() != null){
                dto.setVoertuigDto(voertuigService.transferToDto(tv.getVoertuig()));
            }
            tvDtoList.add(dto);
        }
        return tvDtoList;
    }
    public void assignVoertuigToBestuurder(Long id, Long voertuigId) {
        var optionalBestuurder = bestuurderRepository.findById(id);
        var optionalVoertuig = voertuigRepository.findById(voertuigId);

        if(optionalBestuurder.isPresent() && optionalVoertuig.isPresent()) {
            var bestuurder = optionalBestuurder.get();
            var voertuig = optionalVoertuig.get();

            bestuurder.setVoertuig(voertuig);
            bestuurderRepository.save(bestuurder);
        } else {
            throw new RecordNotFoundException();
        }
    }
}
