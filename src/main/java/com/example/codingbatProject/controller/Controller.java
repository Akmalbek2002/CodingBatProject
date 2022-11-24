package com.example.codingbatProject.controller;

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

}
