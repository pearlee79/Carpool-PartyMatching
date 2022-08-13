package com.carpool.partyMatch.domain.kafka;

import com.carpool.partyMatch.AbstractEvent;
import com.carpool.partyMatch.domain.MatchStatus;

public class MatchAccepted extends AbstractEvent{
    Long id;
    Long partyInfoId;
    Long userId;
    MatchStatus matchStatus;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {this.id = id;}

    public Long getPartyInfoId() {
        return partyInfoId;
    }

    public void setPartyInfoId(Long partyInfoId) {
        this.partyInfoId = partyInfoId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public MatchStatus getMatchStatus() {
        return matchStatus;
    }

    public void setMatchStatus(MatchStatus matchStatus) {
        this.matchStatus = matchStatus;
    }

}
