package com.carpool.partyMatch.service.serviceImpl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.carpool.partyMatch.controller.dto.MatchInfoDto;
import com.carpool.partyMatch.domain.MatchInfo;
import com.carpool.partyMatch.repository.MemberRepository;
import com.carpool.partyMatch.service.MatchInfoService;

@Service
@RequiredArgsConstructor
public class MatchInfoServiceImpl implements MatchInfoService {

  private final MatchInfoRepository matchInfoRepository;
 // private final RestTemplate restTemplate;

    @Override
    public List<MatchInfo> findMatchUser(Long partyInfoId){
        log.info("********* findMatchUser *********");
        // log.debug(String.valueOf(matchInfoDTO));


        return matchInfoRepository.findByPartyInfoIdAndMatchStatus(partyInfoId, "WATING");
    }

    @Override
    public MatchInfo registerMatchInfo(MatchInfoDto matchInfoDTO){
        log.info("********* registerMatchInfo *********");
        log.debug(String.valueOf(matchInfoDTO));

        MatchInfo matchInfo = new MatchInfo();
        matchInfo.setPartyInfoId(matchInfoDTO.getPartyInfoId());
        matchInfo.setCarpooler(matchInfoDTO.getUserId(), matchInfoDTO.getUserName());
        matchInfo.setMatchStatus("WATING");

        return matchInfoRepository.save(matchInfo);
    }

    @Override
    public MatchInfo cancelMatchInfo(MatchInfoDto matchInfoDTO){
        log.info("********* cancelMatchInfo *********");
        log.debug(String.valueOf(matchInfoDTO));

        MatchInfo matchInfo = matchInfoRepository.findByPartyInfoIdAndUserId(matchInfoDTO.getPartyInfoId(), matchInfoDTO.getUserId());
        matchInfo.setMatchStatus("APPLY");

        return matchInfoRepository.save(matchInfo);
    }

}
