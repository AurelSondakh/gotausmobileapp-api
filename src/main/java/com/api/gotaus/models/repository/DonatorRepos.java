package com.api.gotaus.models.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.api.gotaus.models.entities.Donator;

public interface DonatorRepos extends CrudRepository<Donator, Long>{

   // List<Donator> findByNameContains(String name);
}
