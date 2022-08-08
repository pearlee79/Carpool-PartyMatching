package com.carpool.partyMatch.controller.dto;

import lombok.Data;
import java.util.List;

import com.carpool.partyMatch.domain.MatchStatus;
import com.carpool.partyMatch.domain.MatchInfo;

@Data
public class MatchInfoListResponse {

  private List<MatchInfo> matchInfoList;

  public MatchInfoListResponse(List<MatchInfo> matchInfoList){
    this.matchInfoList = matchInfoList;
  }
}
