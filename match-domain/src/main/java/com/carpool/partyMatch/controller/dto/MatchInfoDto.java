package com.carpool.partyMatch.controller.dto;

import lombok.Data;

import com.carpool.partyMatch.domain.MatchStatus;

@Data
public class MatchInfoDto {

  private Long partyInfoId;
  private Long userId;
  private MatchStatus matchStatus;

}
