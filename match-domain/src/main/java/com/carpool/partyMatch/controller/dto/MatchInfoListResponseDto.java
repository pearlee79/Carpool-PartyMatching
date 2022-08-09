package com.carpool.partyMatch.controller.dto;

import lombok.Data;
import java.util.List;

import com.carpool.partyMatch.domain.MatchStatus;
import com.carpool.partyMatch.domain.MatchInfo;

@Data
public class MatchInfoListResponseDto {

  private List<MatchInfo> matchInfoList;

  public MatchInfoListResponseDto(List<MatchInfo> matchInfoList){
    this.matchInfoList = matchInfoList;
  }
}
