package com.example.petstore;

import com.example.petstore.domain.*;

import org.springframework.data.repository.CrudRepository;

public interface PartyInfoRepository extends CrudRepository<PartyInfo, Long>{    // Repository Pattern Interface
  
}