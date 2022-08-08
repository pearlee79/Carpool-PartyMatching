package com.carpool.partyMatch.controller;

import java.util.List;

import org.springframework.context.annotation.Description;
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
import com.carpool.partyMatch.controller.dto.MatchProcessDto;
import com.carpool.partyMatch.controller.dto.MatchInfoListResponse;
import com.carpool.partyMatch.domain.MatchInfo;
import com.carpool.partyMatch.service.MatchInfoService;



@RestController
@RequiredArgsConstructor
public class MatchInfoController {

  final private MatchInfoService matchInfoService;

  @Autowired
	private MatchInfoService MatchInfoService;

  @Description("파티 매칭 정보 조회")
  @PostMapping("/matches/{partyInfoId}")
	public ResponseEntity<MatchInfoListResponse> getMatchUser(@PathVariable Long partyInfoId) {

    // return matchInfoService.findMatchUser(partyInfoId);
    List<MatchInfo> matchInfo = matchInfoService.findMatchUser(partyInfoId);
    MatchInfoListResponse response = new MatchInfoListResponse(matchInfo);
    return ResponseEntity.ok(response);
	}

  @Description("파티 신청")
  @PostMapping("/matches/apply")
	public ResponseEntity<MatchInfoDto> applyParty(@RequestBody MatchInfoDto matchInfoDto) {
    // log.info("***************** MatchInfoController : 파티 신청 Postmapping 호출 *****************");
    matchInfoService.registerMatchInfo(matchInfoDto);

    return ResponseEntity.ok(matchInfoDto);
	}

  @Description("파티 신청 취소")
  @PostMapping("/matches/cancel")
	public ResponseEntity<MatchInfoDto> cancelPartyApplication(@RequestBody MatchInfoDto matchInfoDto) {

    matchInfoService.cancelMatchInfo(matchInfoDto);

    return ResponseEntity.ok(matchInfoDto);
	}

  @Description("파티 신청 수락")
  @PostMapping("/matches/accept")
	public ResponseEntity<MatchProcessDto> acceptPartyApplication(@RequestBody MatchProcessDto matchProcessDto) {

    matchInfoService.acceptMatchInfo(matchProcessDto);

    return ResponseEntity.ok(matchProcessDto);
	}

  @Description("파티 신청 거절")
  @PostMapping("/matches/deny")
	public ResponseEntity<MatchProcessDto> denyPartyApplication(@RequestBody MatchProcessDto matchProcessDto) {

    matchInfoService.denyMatchInfo(matchProcessDto);

    return ResponseEntity.ok(matchProcessDto);
	}

  @Description("파티 시작")
  @PostMapping("/matches/partyStart")
	public void startParty(@RequestBody MatchProcessDto matchProcessDto) {
    matchInfoService.startParty(matchProcessDto);

    // return ResponseEntity.ok(matchProcessDto);
	}

  @Description("파티 종료")
  @PostMapping("/matches/partyClose")
	public void closeParty(@RequestBody MatchProcessDto matchProcessDto) {
    matchInfoService.closeParty(matchProcessDto);

    // return ResponseEntity.ok(matchProcessDto);
	}

}
