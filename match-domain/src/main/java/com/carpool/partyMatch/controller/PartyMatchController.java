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
import com.carpool.partyMatch.service.PartyMatchService;

@RestController
@RequiredArgsConstructor
public class PartyMatchController {

  @Autowired
	private PartyMatchService partyMatchService;

  @PostMapping("/matches/applyParty")
	  public void applyParty(@RequestBody PartyMatchDto partyMatchDto) {

      try{
        MatchInfo matchInfo = new MatchInfo();
        matchInfo.setMatchStatus(MatchStatus.WATING);
      }
      catch(Exception e){

      }
	  }

}
