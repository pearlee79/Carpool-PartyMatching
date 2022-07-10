package com.carpool.matching;

import com.carpool.matching.domain.*;

import org.springframework.data.repository.CrudRepository;

public interface PartyInfoRepository extends CrudRepository<PartyInfo, Long>{    // Repository Pattern Interface

}
