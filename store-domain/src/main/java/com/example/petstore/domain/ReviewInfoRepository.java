package com.example.petstore;


import com.example.petstore.domain.*;

import org.springframework.data.repository.CrudRepository;

public interface ReviewInfoRepository extends CrudRepository<ReviewInfo, Long>{    // Repository Pattern Interface
  
}