package com.example.codingbatProject.service;

import com.example.codingbatProject.entity.Tillar;
import com.example.codingbatProject.payload.APIResponse;
import com.example.codingbatProject.repository.TillarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CodingService {
    @Autowired
    TillarRepository tillarRepository;
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
}
