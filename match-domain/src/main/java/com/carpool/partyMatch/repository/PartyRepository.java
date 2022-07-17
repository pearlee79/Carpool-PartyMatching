package com.carpool.partyMatch.repository;

import com.carpool.partyMatch.domain.*;

import org.springframework.data.repository.CrudRepository;

public interface PartyRepository extends CrudRepository<Party, Long>{    // Repository Pattern Interface

}
