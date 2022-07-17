package com.carpool.partyMatch.repository;

import com.carpool.partyMatch.domain.*;

import org.springframework.data.repository.CrudRepository;

public interface PartyMatchRepository extends CrudRepository<PartyMatch, Long>{    // Repository Pattern Interface

}
