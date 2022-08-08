package com.carpool.partyMatch.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.carpool.partyMatch.domain.MatchInfo;
import com.carpool.partyMatch.controller.dto.MatchInfoDto;
import com.carpool.partyMatch.controller.dto.MatchProcessDto;

public interface MatchInfoService {

  public List<MatchInfo> findMatchUser(Long partyInfoId);

  public void registerMatchInfo(MatchInfoDto matchInfoDto);

  public void cancelMatchInfo(MatchInfoDto matchInfoDto);

  public void acceptMatchInfo(MatchProcessDto matchProcessDto);

  public void denyMatchInfo(MatchProcessDto matchProcessDto);

  public void startParty(MatchProcessDto matchProcessDto);

  public void closeParty(MatchProcessDto matchProcessDto);
}
