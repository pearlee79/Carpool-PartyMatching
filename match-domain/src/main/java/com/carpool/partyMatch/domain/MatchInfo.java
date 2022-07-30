package com.carpool.partyMatch.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.FetchType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import java.util.List;
//import javax.persistence.OneToMany;

@Entity
public class MatchInfo {
  @Id @GeneratedValue
  Long id;

  Long partyInfoId;

  @Embedded
  Carpooler carpooler;

  MatchStatus matchStatus;

    public Party getParty() {
        return party;
    }

    public void setParty(Party party) {
        this.party = party;
    }

    public Carpooler getCarpooler() {
        return carpooler;
    }

    public void setCarpooler(Carpooler carpooler) {
        this.carpooler = carpooler;
    }

    public MatchStatus getMatchStatus() {
            return matchStatus;
    }

    public void setMatchStatus(MatchStatus matchStatus) {
        this.matchStatus = matchStatus;
    }


}
