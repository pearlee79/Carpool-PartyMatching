package com.carpool.matching.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import com.carpool.matching.domain.PartyInfo;
import com.carpool.matching.service.PartyMatchingService;

@RestController
@RequiredArgsConstructor
public class PartyMatchingController {

  @Autowired
	private PartyMatchingService partyMatchingService;

  @PostMapping("/matchings/applyParty")
	  public ResponseEntity<List<Booking>> applyParty(@RequestBody PartyMatchingDto partyMatchingDto) {
      PartyMatchingDto partyMatchingDto = new PartyMatchingDto();
      try{
        PartyMember partyMember = new PartyMember();
        partyMember.setPartyInfoId(partyMatchingDto.getPartyInfoId());
        partyMember.setMemberId(partyMatchingDto.getMemberId());
      }
      catch(Exception e){

      }
	  }

}
