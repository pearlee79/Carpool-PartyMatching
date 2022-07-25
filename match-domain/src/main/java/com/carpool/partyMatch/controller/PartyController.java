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
import com.carpool.partyMatch.domain.MatchInfo;
import com.carpool.partyMatch.service.MatchInfoService;


@RestController
@RequiredArgsConstructor
public class PartyController {


  @Autowired
	private PartyService partyService;

  //파티 시작
  @PostMapping("/parties/{partyInfoId}/start")
	public Party startParty(@PathVariable(value = "partyInfoId") Long partyInfoId,
                                      @RequestParam(required = false) Long userId) {
	}

  //파티 종료
  @PostMapping("/parties/{{partyInfoId}/close")
	public Party closeParty(@PathVariable(value = "partyInfoId") Long partyInfoId,
                                      @RequestParam(required = false) Long userId) {
	}

}
