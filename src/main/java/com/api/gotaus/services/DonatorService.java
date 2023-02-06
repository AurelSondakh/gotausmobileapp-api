package com.api.gotaus.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.gotaus.models.entities.Donator;
import com.api.gotaus.models.repository.DonatorRepos;

import jakarta.transaction.TransactionScoped;

@Service
@TransactionScoped
public class DonatorService {
    
    @Autowired
    private DonatorRepos donatorRepo;

    public Donator save(Donator donator){
        return donatorRepo.save(donator);
    }

    public Donator findOne(Long id){
        Optional<Donator> donator = donatorRepo.findById(id);
        if(!donator.isPresent()){
            return null;
        }
        return donatorRepo.findById(id).get();
    }

    public Iterable<Donator> findAll(){
        return donatorRepo.findAll();
    }

    public void removeOne(Long id){
        donatorRepo.deleteById(id);
    }

    // public List<Donator> findByName(String Name){
    //     return donatorRepo.findByNameContains(Name);
    // }
}
