package com.example.codingbatProject.controller;

import com.example.codingbatProject.dto.JavobDTO;
import com.example.codingbatProject.dto.KategoriyaDTO;
import com.example.codingbatProject.dto.SavollarDTO;
import com.example.codingbatProject.entity.Tillar;
import com.example.codingbatProject.payload.APIResponse;
import com.example.codingbatProject.service.CodingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/codingbat")
public class Controller {
    @Autowired
    CodingService codingService;

    // Tillar CRUDi
    @PostMapping("/tiljoylash")
    public HttpEntity<?> tiljoylash(@RequestBody Tillar tillar){
        APIResponse apiResponse=codingService.tiljoylash(tillar);
        return ResponseEntity.status(apiResponse.isHolat()? HttpStatus.OK:HttpStatus.ALREADY_REPORTED).body(apiResponse.getXabar());
    }
    @GetMapping("/tiloqish/{id}")
    public HttpEntity<?> tiloqish(@PathVariable Integer id){
        APIResponse apiResponse=codingService.tiloqish(id);
        return ResponseEntity.status(apiResponse.isHolat()?HttpStatus.OK:HttpStatus.NOT_FOUND).body(apiResponse.getXabar());
    }
    @PutMapping("/tiltahrirlash/{id}")
    public HttpEntity<?> tiltahrirlash(@PathVariable Integer id,@RequestBody Tillar tillar){
        APIResponse apiResponse=codingService.tiltahrirlash(id,tillar);
        return ResponseEntity.status(apiResponse.isHolat()?HttpStatus.OK:HttpStatus.NOT_FOUND).body(apiResponse.getXabar());
    }
    @DeleteMapping("/tilochirish/{id}")
    public HttpEntity<?> tilochirish(@PathVariable Integer id){
        APIResponse apiResponse=codingService.tilochirish(id);
        return ResponseEntity.status(apiResponse.isHolat()?HttpStatus.OK:HttpStatus.NOT_FOUND).body(apiResponse.getXabar());
    }

    // Kategoriya CRUDi
    @PostMapping("/kategoriyaQoshish")
    public HttpEntity<?> kategoriyaQoshish(@RequestBody KategoriyaDTO kategoriya){
        APIResponse apiResponse=codingService.kategoriyaQoshish(kategoriya);
        return ResponseEntity.status(apiResponse.isHolat()?HttpStatus.OK:HttpStatus.ALREADY_REPORTED).body(apiResponse.getXabar());
    }
    @GetMapping("/kategoriyaOqish/{id}")
    public HttpEntity<?> kategoriyaOqish(@PathVariable Integer id){
        APIResponse apiResponse=codingService.kategoriyaOqish(id);
        return ResponseEntity.status(apiResponse.isHolat()?HttpStatus.OK : HttpStatus.NOT_FOUND).body(apiResponse.getXabar());
    }
    @PutMapping("/kategoriyatahrirlash/{id}")
    public HttpEntity<?> kategoriyatahrirlash(@PathVariable Integer id,@RequestBody KategoriyaDTO kategoriyaDTO){
        APIResponse apiResponse=codingService.kategoriyatahrirlash(id,kategoriyaDTO);
        return ResponseEntity.status(apiResponse.isHolat() ? HttpStatus.OK:HttpStatus.NOT_FOUND).body(apiResponse.getXabar());
    }
    @DeleteMapping("/kategoriyaOchirish/{id}")
    public HttpEntity<?> kategoriyaOchirish(@PathVariable Integer id){
        APIResponse apiResponse=codingService.kategoriya_ochirish(id);
        return ResponseEntity.status(apiResponse.isHolat() ? HttpStatus.OK:HttpStatus.NOT_FOUND).body(apiResponse.getXabar());
    }

    // Savollar CRUDi
    @PostMapping("/savollarjoylash")
    public HttpEntity<?> savoljoylash(@RequestBody SavollarDTO savollarDTO){
        APIResponse apiResponse=codingService.savolJoylash(savollarDTO);
        return ResponseEntity.status(apiResponse.isHolat() ? HttpStatus.OK:HttpStatus.ALREADY_REPORTED).body(apiResponse.getXabar());
    }
    @GetMapping("/savollaroqish")
    public HttpEntity<?> savoloqish(@PathVariable Integer id){
        APIResponse apiResponse=codingService.savolOqish(id);
        return ResponseEntity.status(apiResponse.isHolat() ? HttpStatus.OK:HttpStatus.NOT_FOUND).body(apiResponse.getXabar());
    }
    @PutMapping("/savollartahrirlash")
    public HttpEntity<?> savoltahrirlash(@PathVariable Integer id, @RequestBody SavollarDTO savollarDTO){
        APIResponse apiResponse=codingService.savoltahrirlash(id,savollarDTO);
        return ResponseEntity.status(apiResponse.isHolat() ? HttpStatus.OK:HttpStatus.NOT_FOUND).body(apiResponse.getXabar());
    }
    @DeleteMapping("/savollarOchirish")
    public HttpEntity<?> savolochirish(@PathVariable Integer id){
        APIResponse apiResponse=codingService.savolOchirish(id);
        return ResponseEntity.status(apiResponse.isHolat() ? HttpStatus.OK:HttpStatus.NOT_FOUND).body(apiResponse.getXabar());
    }

    // Javoblar CRUDi
    @PostMapping("/javobjoylash")
    public HttpEntity<?> javobjoylash(@RequestBody JavobDTO javobDTO){
        APIResponse apiResponse=codingService.javobJoylash(javobDTO);
        return ResponseEntity.status(apiResponse.isHolat() ? HttpStatus.OK:HttpStatus.).body(apiResponse.getXabar());
    }


}
