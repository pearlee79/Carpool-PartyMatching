package com.example.petstore.domain;


import com.example.petstore.domain.*;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Item, Long>{    // Repository Pattern Interface  // Dependency Inversion Principle

    Optional<Customer> findByCustomerId(Long customerId); // select * from item where petId=<petId>
  
}