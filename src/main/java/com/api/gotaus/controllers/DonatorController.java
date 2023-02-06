package com.api.gotaus.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.gotaus.dto.ResponseData;
import com.api.gotaus.models.entities.Donator;
import com.api.gotaus.services.DonatorService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/donator")
public class DonatorController {
    
    @Autowired
    private DonatorService donatorService;

    @PostMapping
    public ResponseEntity<ResponseData<Donator>> create(@Valid @RequestBody Donator donator, Errors errors){
        ResponseData<Donator> responseData = new ResponseData<>();

        if(errors.hasErrors()){
            for(ObjectError error : errors.getAllErrors()){
                responseData.getMessage().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
        responseData.setStatus(true);
        responseData.setPayload(donatorService.save(donator));
        return ResponseEntity.ok(responseData);
    }

    @GetMapping
    public Iterable<Donator> findAll(){
        return donatorService.findAll();
    }

    @GetMapping("/{id}")
    public Donator findOne(@PathVariable("id") long id){
        return donatorService.findOne(id);
    }

    @PutMapping
    public Donator update(@RequestBody Donator donator){
        return donatorService.save(donator);
    }

    @DeleteMapping("/{id}")
    public void removeOne(@PathVariable("id") Long id){
        donatorService.removeOne(id);
    }
}
