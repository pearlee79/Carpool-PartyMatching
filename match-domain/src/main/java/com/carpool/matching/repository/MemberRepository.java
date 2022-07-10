package com.carpool.matching.domain;


import com.carpool.matching.domain.*;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member, Long>{    // Repository Pattern Interface  // Dependency Inversion Principle

    Optional<Member> findByCustomerId(Long customerId); // select * from item where petId=<petId>

}
