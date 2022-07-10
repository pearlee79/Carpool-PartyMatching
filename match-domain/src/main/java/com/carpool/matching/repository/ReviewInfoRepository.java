package com.carpool.matching;


import com.carpool.matching.domain.*;

import org.springframework.data.repository.CrudRepository;

public interface ReviewInfoRepository extends CrudRepository<ReviewInfo, Long>{    // Repository Pattern Interface

}
