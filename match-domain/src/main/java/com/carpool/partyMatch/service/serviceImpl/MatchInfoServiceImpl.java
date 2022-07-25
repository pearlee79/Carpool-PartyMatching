package com.carpool.partyMatch.service.serviceImpl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.carpool.partyMatch.repository.MemberRepository;
import com.carpool.partyMatch.service.MatchInfoService;

@Service
@RequiredArgsConstructor
public class MatchInfoServiceImpl implements MatchInfoService {

  private final MatchInfoRepository matchInfoRepository;
 // private final RestTemplate restTemplate;

 @Override
    public ParkingLot registerParkingLot(MatchInfoDTO matchInfoDTO){
        log.info("********* registerMatchInfo *********");
        log.debug(String.valueOf(matchInfoDTO));

        return matchInfoRepository.save(parkingLot);
    }
}
