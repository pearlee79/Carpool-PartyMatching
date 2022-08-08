package com.carpool.partyMatch.service.serviceImpl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.carpool.partyMatch.controller.dto.MatchInfoDto;
import com.carpool.partyMatch.controller.dto.MatchProcessDto;
import com.carpool.partyMatch.domain.MatchInfo;
import com.carpool.partyMatch.domain.Party;
import com.carpool.partyMatch.domain.Carpooler;
import com.carpool.partyMatch.domain.Driver;
import com.carpool.partyMatch.domain.MatchStatus;
import com.carpool.partyMatch.domain.PartyStatus;
import com.carpool.partyMatch.repository.MatchInfoRepository;
import com.carpool.partyMatch.repository.PartyRepository;
import com.carpool.partyMatch.service.MatchInfoService;
import com.carpool.partyMatch.exception.ApiException;
import com.carpool.partyMatch.exception.ErrorCode;

import java.lang.RuntimeException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MatchInfoServiceImpl implements MatchInfoService {

  private final MatchInfoRepository matchInfoRepository;
  private final PartyRepository partyRepository;;
 // private final RestTemplate restTemplate;

    @Override
    public List<MatchInfo> findMatchUser(Long partyInfoId){
        // log.info("********* findMatchUser *********");
        // log.debug(String.valueOf(matchInfoDto));

        List<MatchInfo> matchInfoList = matchInfoRepository.findByPartyInfoIdAndMatchStatus(partyInfoId, MatchStatus.WATING);

        return matchInfoList;
    }

    @Override
    public void registerMatchInfo(MatchInfoDto matchInfoDto){
        // log.info("********* registerMatchInfo *********");
        // log.debug(String.valueOf(matchInfoDto));

        //파티 상태 확인 (시작 또는 종료이면 신청 불가)
        MatchInfo matchInfo = new MatchInfo();
        matchInfo.setPartyInfoId(matchInfoDto.getPartyInfoId());
        matchInfo.setUserId(matchInfoDto.getUserId());
        matchInfo.setMatchStatus(MatchStatus.WATING);

        matchInfoRepository.save(matchInfo);
    }

    @Override
    public void cancelMatchInfo(MatchInfoDto matchInfoDto){
        // log.info("********* cancelMatchInfo *********");
        // log.debug(String.valueOf(matchInfoDto));

        //파티 상태 확인 (시작 또는 종료이면 취소 불가)
        MatchInfo matchInfo = matchInfoRepository.findByPartyInfoIdAndUserId(matchInfoDto.getPartyInfoId(), matchInfoDto.getUserId());
        // .orElseThrow(() -> new ApiException(ErrorCode.POSTS_NOT_FOUND));

        matchInfo.setMatchStatus(MatchStatus.CANCEL);

        matchInfoRepository.save(matchInfo);
    }

    @Override
    public void acceptMatchInfo(MatchProcessDto matchProcessDto){
        // log.info("********* acceptMatchInfo *********");
        // log.debug(String.valueOf(matchProcessDto));

        Party party = partyRepository.findByPartyInfoId(matchProcessDto.getPartyInfoId());
        MatchInfo matchInfo =  matchInfoRepository.findByPartyInfoIdAndUserId(matchProcessDto.getPartyInfoId(), matchProcessDto.getUserId());

        //운전자 확인 또는 세션 확인
        Driver driver = party.getDriver();

        if(matchProcessDto.getDriverId() == driver.getDriverId()){
            matchInfo.setMatchStatus(MatchStatus.ACCEPT);
        }

        //파티 수락 이벤트 발행
        // matchInfoProducer.sendMessage();

        matchInfoRepository.save(matchInfo);
    }

    //파티관리 서비스에서 신청 가능 인원 확인 후 신청 불가할 경우에도 아래 실행
    @Override
    public void denyMatchInfo(MatchProcessDto matchProcessDto){
        // log.info("********* denyMatchInfo *********");
        // log.debug(String.valueOf(matchProcessDto));

        Party party = partyRepository.findByPartyInfoId(matchProcessDto.getPartyInfoId());
        MatchInfo matchInfo = matchInfoRepository.findByPartyInfoIdAndUserId(matchProcessDto.getPartyInfoId(), matchProcessDto.getUserId());

        //운전자 확인 또는 세션 확인
        Driver driver = party.getDriver();

        if(matchProcessDto.getDriverId() == driver.getDriverId()){
            matchInfo.setMatchStatus(MatchStatus.DENY);
        }

        //파티 수락 이벤트 발행
        // matchInfoProducer.sendMessage();

        matchInfoRepository.save(matchInfo);
    }


    @Override
    public void startParty(MatchProcessDto matchProcessDto){
        // log.info("********* startParty *********");
        // log.debug(String.valueOf(matchProcessDto));

        Party party = partyRepository.findByPartyInfoId(matchProcessDto.getPartyInfoId());

        //운전자 확인 또는 세션 확인
        Driver driver = party.getDriver();

        if(matchProcessDto.getDriverId() == driver.getDriverId()){
            party.setPartyStatus(PartyStatus.FORMED);
            partyRepository.save(party);
        }

        //파티 시작 이벤트 발행
        // matchInfoProducer.sendMessage();

        // return partyRepository.save(party);
    }


    @Override
    public void closeParty(MatchProcessDto matchProcessDto){
        // log.info("********* closeParty *********");
        // log.debug(String.valueOf(matchProcessDto));

        Party party = partyRepository.findByPartyInfoId(matchProcessDto.getPartyInfoId());

        //운전자 확인 또는 세션 확인
        Driver driver = party.getDriver();

        if(matchProcessDto.getDriverId() == driver.getDriverId()){
            party.setPartyStatus(PartyStatus.CLOSED);
            partyRepository.save(party);
        }

        //파티 종료 이벤트 발행
        // matchInfoProducer.sendMessage();
    }

}
