package com.carpool.partyMatch.domain;

//import java.util.List;

import javax.persistence.Embeddable;

@Entity
public class Party {
    @Id @GeneratedValue
    Long id;
    Long partyInfoId;

    @Embedded
    Driver driver;

    PartyStatus partyStatus;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public PartyStatus getPartyStatus() {
            return partyStatus;
        }

        public void setPartyStatus(PartyStatus partyStatus) {
            this.partyStatus = partyStatus;
        }

        public Long getDriver() {
            return driver;
        }

        public void setDriver(Long driver) {
            this.driver = driver;
        }
}
