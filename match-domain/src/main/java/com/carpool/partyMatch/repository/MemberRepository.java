package com.carpool.partyMatch.domain;


import com.carpool.partyMatch.domain.*;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member, Long>{    // Repository Pattern Interface  // Dependency Inversion Principle

    Optional<Member> findByMemberId(Long memberId); // select * from item where petId=<petId>

}
