package com.carpool.partyMatch.service;

import java.util.List;

import org.springframework.data.repository.query.Param;


import com.carpool.partyMatch.domain.MatchInfo;


public interface MatchInfoService {

  public List<MatchInfo> findMatchInfoListByPartyId(Long partyId);

  public MatchInfo registerMatchInfo(MatchInfoDTO matchInfoDTO);

  public MatchInfo canMatchInfo(MatchInfoDTO matchInfoDTO);
}
