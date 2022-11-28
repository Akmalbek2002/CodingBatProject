package com.example.codingbatProject.service;

import com.example.codingbatProject.dto.KategoriyaDTO;
import com.example.codingbatProject.dto.SavollarDTO;
import com.example.codingbatProject.entity.Kategoriya;
import com.example.codingbatProject.entity.Namuna;
import com.example.codingbatProject.entity.Savollar;
import com.example.codingbatProject.entity.Tillar;
import com.example.codingbatProject.payload.APIResponse;
import com.example.codingbatProject.repository.KategoriyaRepository;
import com.example.codingbatProject.repository.NamunaRepository;
import com.example.codingbatProject.repository.Savollar_Repository;
import com.example.codingbatProject.repository.TillarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CodingService {
    @Autowired
    TillarRepository tillarRepository;
    @Autowired
    KategoriyaRepository kategoriyaRepository;
    @Autowired
    Savollar_Repository savollar_repository;
    @Autowired
    NamunaRepository namunaRepository;
    public APIResponse tiljoylash(Tillar tillar) {
        Optional<Tillar> byNomi = tillarRepository.findByNomi(tillar.getNomi());
        if(!byNomi.isPresent()){
            tillarRepository.save(tillar);
            return new APIResponse("Til qo'shildi",true);
        }
        return new APIResponse("Bunday til mavjud",false);
    }

    public APIResponse tiloqish(Integer id) {
        Optional<Tillar> byId = tillarRepository.findById(id);
        if(byId.isPresent()){
            String xabar=byId.get().toString();
            return new APIResponse(xabar,true);
        }
        return new APIResponse("Bunday idli til mavjud emas",false);
    }

    public APIResponse tiltahrirlash(Integer id, Tillar tillar) {
        Optional<Tillar> byId = tillarRepository.findById(id);
        if(byId.isPresent()){
            Tillar tillar1=byId.get();
            tillarRepository.save(tillar1);
            return new APIResponse("Til tahrirlandi",true);
        }
        return new APIResponse("Bunday idli til mavjud emas",false);
    }

    public APIResponse tilochirish(Integer id) {
        Optional<Tillar> byId = tillarRepository.findById(id);
        if(byId.isPresent()){
            tillarRepository.deleteById(id);
            return new APIResponse("Til o'chirildi",true);
        }
        return new APIResponse("Bunday idli til mavjud emas",false);
    }

    public APIResponse kategoriyaQoshish(KategoriyaDTO kategoriya) {
        Optional<Kategoriya> byKategoriyaNomi = kategoriyaRepository.findByKategoriyaNomi(kategoriya.getKategoriyaNomi());
        if(!byKategoriyaNomi.isPresent()){
            List<Tillar> list=new ArrayList<>();
            for (Integer a : kategoriya.getIntegerList()) {
                if(tillarRepository.existsById(a)){
                    list.add(tillarRepository.findById(a).get());
                }
            }
            Kategoriya kategoriya1=new Kategoriya();
            kategoriya1.setKategoriyaNomi(kategoriya.getKategoriyaNomi());
            kategoriya1.setIzoh(kategoriya.getIzoh());
            kategoriya1.setYulduzchalarSoni(kategoriya.getYulduzchalarSoni());
            kategoriya1.setList(list);
            kategoriyaRepository.save(kategoriya1);
            return new APIResponse("Kategoriya qo'shildi",true);
        }
        return new APIResponse("Bunday kategoriya bazada mavjud",false);
        }

    public APIResponse kategoriyaOqish(Integer id) {
        Optional<Kategoriya> byId = kategoriyaRepository.findById(id);
        if(byId.isPresent()){
            String xabar=byId.get().toString();
            return new APIResponse(xabar,true);
        }
        return new APIResponse("Bunday idli kategoriya mavjud emas",false);
    }

    public APIResponse kategoriyatahrirlash(Integer id, KategoriyaDTO kategoriyaDTO) {
        Optional<Kategoriya> byId = kategoriyaRepository.findById(id);
        if(byId.isPresent()){
            Kategoriya kategoriya=byId.get();
            kategoriya.setKategoriyaNomi(kategoriyaDTO.getKategoriyaNomi());
            kategoriya.setIzoh(kategoriyaDTO.getIzoh());
            kategoriya.setYulduzchalarSoni(kategoriyaDTO.getYulduzchalarSoni());
            List<Tillar> list=new ArrayList<>();
            for (Integer a : kategoriyaDTO.getIntegerList()) {
                list.add(tillarRepository.findById(a).get());
            }
            kategoriya.setList(list);
            kategoriyaRepository.save(kategoriya);
            return new APIResponse("Tahrirlandi",true);
        }
        return new APIResponse("Bunday idli kategoriya mavjud emas",false);
    }

    public APIResponse kategoriya_ochirish(Integer id) {
        Optional<Kategoriya> byId = kategoriyaRepository.findById(id);
        if(byId.isPresent()){
            kategoriyaRepository.deleteById(id);
            return new APIResponse("Kategoriya o'chirildi",true);
        }
        return new APIResponse("Bunday idli kategoriya mavjud",false);
    }

    public APIResponse savolJoylash(SavollarDTO savollarDTO) {
        Optional<Savollar> bySavolNomiAndSavolMatni = savollar_repository.findBySavolNomiAndSavolMatni(savollarDTO.getSavolNomi(), savollarDTO.getSavolMatni());
        if (!bySavolNomiAndSavolMatni.isPresent()){
            Savollar savollar=new Savollar();
            savollar.setSavolNomi(savollarDTO.getSavolNomi());
            savollar.setSavolMatni(savollarDTO.getSavolMatni());
            savollar.setYechim(savollarDTO.getYechim());
            savollar.setFunksiya(savollarDTO.getFunksiya());
            Namuna namuna=new Namuna();
            namuna.setMatn(savollarDTO.getNamuna());
            savollar.setNamuna(namuna);
            List<Kategoriya> kategoriyaList=new ArrayList<>();
            for (Integer a : savollarDTO.getKategoriyaList()) {
                kategoriyaList.add(kategoriyaRepository.findById(a).get());
            }
            savollar.setKategoriyaList(kategoriyaList);
            savollar_repository.save(savollar);
            namunaRepository.save(namuna);
            return new APIResponse("Savol qo'shildi",true);
    }
        return new APIResponse("Bunday savol mavjud",false);
}

    public APIResponse savolOqish(Integer id) {
        Optional<Savollar> byId = savollar_repository.findById(id);
        if(byId.isPresent()){
            String xabar=byId.get().toString();
            return new APIResponse(xabar,true);
        }
        return new APIResponse("Bunday idli savol mavjud emas",false);
    }

    public APIResponse savoltahrirlash(Integer id, SavollarDTO savollarDTO) {
        Optional<Savollar> byId = savollar_repository.findById(id);
        if(byId.isPresent()){
            Savollar savollar=byId.get();
            savollar.setSavolNomi(savollarDTO.getSavolNomi());
            savollar.setSavolMatni(savollarDTO.getSavolMatni());
            savollar.setYechim(savollarDTO.getYechim());
            savollar.setFunksiya(savollarDTO.getFunksiya());
            Namuna namuna=namunaRepository.findById(savollar_repository.findById(id).get().getNamuna().getId()).get();
            namuna.setMatn(savollarDTO.getNamuna());
            List<Kategoriya> list=new ArrayList<>();
            for (Integer a : savollarDTO.getKategoriyaList()) {
                list.add(kategoriyaRepository.findById(a).get());
            }
            savollar.setKategoriyaList(list);
            savollar_repository.save(savollar);
            namunaRepository.save(namuna);
            return new APIResponse("Savol tahrirlandi",true);
        }
        return new APIResponse("Bunday idli savol mavjud emas",false);
    }

    public APIResponse savolOchirish(Integer id) {
        Optional<Savollar> byId = savollar_repository.findById(id);
        if(byId.isPresent()){
            savollar_repository.deleteById(id);
            namunaRepository.deleteById(savollar_repository.findById(id).get().getNamuna().getId());
            return new APIResponse("Savol ochirildi",true);
        }
        return new APIResponse("Bunday idli savol mavjud emas",false);
    }
}
