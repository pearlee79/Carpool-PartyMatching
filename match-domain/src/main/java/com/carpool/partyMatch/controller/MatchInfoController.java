package com.carpool.partyMatch.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import com.carpool.partyMatch.domain.MatchStatus;
import com.carpool.partyMatch.domain.Party;
import com.carpool.partyMatch.controller.dto.MatchInfoDto;
import com.carpool.partyMatch.domain.MatchInfo;
import com.carpool.partyMatch.service.MatchInfoService;


@RestController
@RequiredArgsConstructor
public class MatchInfoController {

  final private MatchInfoService matchInfoService;

  @Autowired
	private MatchInfoService MatchInfoService;

  //파티 매칭 정보 조회
  @PostMapping("/matches/{partyInfoId}")
	public List<MatchInfo> getMatchUser(@PathVariable Long partyInfoId) {
    return matchInfoService.findMatchUser(partyInfoId);
	}

  //파티 신청
  @PostMapping("/matches/apply")
	public MatchInfo applyParty(@RequestBody MatchInfoDto matchInfoDto) {
    log.info("***************** MatchInfoController : 파티 신청 Postmapping 호출 *****************");
    matchInfoService.registerMatchInfo(matchInfoDto);
	}

  //파티 신청 취소
  @PostMapping("/matches/cancel")
	public MatchInfo cancelPartyApplication(@RequestBody MatchInfoDto matchInfoDto) {
    matchInfoService.cancelMatchInfo(matchInfoDto);
	}

  //파티 신청 수락
  @PostMapping("/matches/accept")
	public MatchInfo acceptPartyApplication(@RequestBody MatchProcessDto matchProcessDto) {
    matchInfoService.acceptMatchInfo(matchInfoDto);
	}

  //파티 신청 거절
  @PostMapping("/matches/deny")
	public MatchInfo denyPartyApplication(@RequestBody MatchProcessDto matchProcessDto) {
    matchInfoService.denyMatchInfo(matchInfoDto);
	}

  //파티 시작
  @PostMapping("/matches/partyStart")
	public Party startParty(@RequestBody MatchProcessDto matchProcessDto) {
    matchInfoService.startParty(matchInfoDto);
	}

  //파티 종료
  @PostMapping("/matches/partyClose")
	public Party closeParty(@RequestBody MatchProcessDto matchProcessDto) {
    matchInfoService.closeParty(matchInfoDto);
	}

}
