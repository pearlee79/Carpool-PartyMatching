package com.carpool.partyMatch.service.serviceImpl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.carpool.partyMatch.controller.dto.MatchInfoDto;
import com.carpool.partyMatch.controller.dto.MatchProcessDto;
import com.carpool.partyMatch.domain.MatchInfo;
import com.carpool.partyMatch.domain.Party;
import com.carpool.partyMatch.repository.MemberRepository;
import com.carpool.partyMatch.repository.PartyRepository;
import com.carpool.partyMatch.service.MatchInfoService;

@Service
@RequiredArgsConstructor
public class MatchInfoServiceImpl implements MatchInfoService {

  private final MatchInfoRepository matchInfoRepository;
  private final PartyRepository partyRepository;
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

        //파티 상태 확인 (시작 또는 종료이면 신청 불가)
        MatchInfo matchInfo = new MatchInfo();
        matchInfo.setPartyInfoId(matchInfoDTO.getPartyInfoId());
        matchInfo.setCarpooler(new Carpooler(matchInfoDTO.getUserId(), matchInfoDTO.getUserName()));
        matchInfo.setMatchStatus("WATING");

        return matchInfoRepository.save(matchInfo);
    }

    @Override
    public MatchInfo cancelMatchInfo(MatchInfoDto matchInfoDTO){
        log.info("********* cancelMatchInfo *********");
        log.debug(String.valueOf(matchInfoDTO));

        //파티 상태 확인 (시작 또는 종료이면 취소 불가)
        MatchInfo matchInfo = matchInfoRepository.findByPartyInfoIdAndUserId(matchInfoDTO.getPartyInfoId(), matchInfoDTO.getUserId());
        matchInfo.setMatchStatus("CANCEL");

        return matchInfoRepository.save(matchInfo);
    }

    @Override
    public MatchInfo acceptMatchInfo(MatchProcessDto matchProcessDTO){
        log.info("********* acceptMatchInfo *********");
        log.debug(String.valueOf(matchProcessDTO));

        Party party = partyRepository.findByPartyInfoId(matchProcessDTO.getPartyInfoId());

        //운전자 확인 또는 세션 확인
        Driver driver = party.getDriver();

        if(matchProcessDTO.getDriverId() == driver.getDriverId()){
            MatchInfo matchInfo = matchInfoRepository.findByPartyInfoIdAndUserId(matchProcessDTO.getPartyInfoId(), matchProcessDTO.getUserId());
            matchInfo.setMatchStatus("ACCEPT");
        }

        //파티 수락 이벤트 발행
        // matchInfoProducer.sendMessage();

        return matchInfoRepository.save(matchInfo);
    }

    //파티관리 서비스에서 신청 가능 인원 확인 후 신청 불가할 경우에도 아래 실행
    @Override
    public MatchInfo denyMatchInfo(MatchProcessDto matchProcessDTO){
        log.info("********* denyMatchInfo *********");
        log.debug(String.valueOf(matchProcessDTO));

        Party party = partyRepository.findByPartyInfoId(matchProcessDTO.getPartyInfoId());

        //운전자 확인 또는 세션 확인
        Driver driver = party.getDriver();

        if(matchProcessDTO.getDriverId() == driver.getDriverId()){
            MatchInfo matchInfo = matchInfoRepository.findByPartyInfoIdAndUserId(matchProcessDTO.getPartyInfoId(), matchProcessDTO.getUserId());
            matchInfo.setMatchStatus("DENY");
        }

        //파티 수락 이벤트 발행
        // matchInfoProducer.sendMessage();

        return matchInfoRepository.save(matchInfo);
    }


    @Override
    public Party startParty(MatchProcessDto matchProcessDTO){
        log.info("********* startParty *********");
        log.debug(String.valueOf(matchProcessDTO));

        Party party = partyRepository.findByPartyInfoId(matchProcessDTO.getPartyInfoId());

        //운전자 확인 또는 세션 확인
        Driver driver = party.getDriver();

        if(matchProcessDTO.getDriverId() == driver.getDriverId()){
            party.setPartyStatus("FORMED");
        }

        //파티 시작 이벤트 발행
        // matchInfoProducer.sendMessage();

        return partyRepository.save(party);
    }


    @Override
    public Party closeParty(MatchProcessDto matchProcessDTO){
        log.info("********* closeParty *********");
        log.debug(String.valueOf(matchProcessDTO));

        Party party = partyRepository.findByPartyInfoId(matchProcessDTO.getPartyInfoId());

        //운전자 확인 또는 세션 확인
        Driver driver = party.getDriver();

        if(matchProcessDTO.getDriverId() == driver.getDriverId()){
            party.setPartyStatus("CLOSE");
        }

        //파티 종료 이벤트 발행
        // matchInfoProducer.sendMessage();

        return partyRepository.save(party);
    }

}
