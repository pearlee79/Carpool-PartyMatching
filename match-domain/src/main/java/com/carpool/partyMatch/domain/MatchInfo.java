package com.carpool.partyMatch.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.FetchType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;
//import javax.persistence.OneToMany;

@Entity
public class MatchInfo {
  @Id @GeneratedValue
  Long id;
  MatchStatus matchStatus;

  public MatchStatus getMatchStatus() {
        return matchStatus;
    }
    public void setMatchStatus(MatchStatus matchStatus) {
        this.matchStatus = matchStatus;
    }

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "member_id")
    Member member;
        public Member getMember() {
            return member;
        }
        public void setMember(Member member) {
            this.member = member;
        }

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "party_id")
    Party party;
        public Party getParty() {
            return party;
        }
        public void setParty(Party party) {
            this.party = party;
        }
    }
