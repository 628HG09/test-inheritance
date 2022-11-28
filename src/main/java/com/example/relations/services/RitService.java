package com.example.relations.services;

import com.example.relations.dtos.RitDto;
import com.example.relations.exceptions.RecordNotFoundException;
import com.example.relations.models.Rit;
import com.example.relations.repositories.BestuurderRepository;
import com.example.relations.repositories.RitRepository;
import org.springframework.stereotype.Service;

@Service
public class RitService {
    private final RitRepository ritRepository;

    private final BestuurderRepository bestuurderRepository;

    private final BestuurderService bestuurderService;

    public RitService(RitRepository ritRepository, BestuurderRepository bestuurderRepository, BestuurderService bestuurderService) {
        this.ritRepository = ritRepository;
        this.bestuurderRepository = bestuurderRepository;
        this.bestuurderService = bestuurderService;
    }

    public RitDto getRitById(Long id) {

        if (ritRepository.findById(id).isPresent()){
            Rit tv = ritRepository.findById(id).get();
            RitDto dto =transferToDto(tv);
            if(tv.getBestuurder() != null){
                dto.setBestuurderDto(bestuurderService.transferToDto(tv.getBestuurder()));
            }
//            if(tv.getRemoteController() != null){
//                dto.setRemoteControllerDto(remoteControllerService.transferToDto(tv.getRemoteController()));
//            }

            return transferToDto(tv);
        } else {
            throw new RecordNotFoundException("geen rit gevonden");
        }
    }
    public RitDto addRit(RitDto dto) {

        Rit tv = transferToRit(dto);
        ritRepository.save(tv);

        return transferToDto(tv);
    }

    public Rit transferToRit(RitDto dto){
        var rit = new Rit();

        rit.setBestemming(dto.getBestemming());
        rit.setOphaalLocatie(dto.getOphaalLocatie());


        return rit;
    }

    public RitDto transferToDto(Rit rit){
        RitDto dto = new RitDto();

        dto.setId(rit.getId());
        dto.setBestemming(rit.getBestemming());
        dto.setOphaalLocatie(rit.getOphaalLocatie());

        if(rit.getBestuurder() != null){
            //bestuurderService begon met een B
            dto.setBestuurderDto(BestuurderService.transferToDto(rit.getBestuurder()));
        }

        return dto;
    }

    public void assignBestuurderToRit(Long id, Long bestuurderId) {
        var optionalRit = ritRepository.findById(id);
        var optionalBestuurder = bestuurderRepository.findById(bestuurderId);

        if(optionalRit.isPresent() && optionalBestuurder.isPresent()) {
            var rit = optionalRit.get();
            var bestuurder = optionalBestuurder.get();

            rit.setBestuurder(bestuurder);
            ritRepository.save(rit);
        } else {
            throw new RecordNotFoundException();
        }
    }



}
