package com.carpool.partyMatch.domain;

//import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;
//import javax.persistence.OneToMany;


@Entity
public class Party {

    @Id  @GeneratedValue
    @Column(name = "party_id")
    Long id;
    Long partyInfoId;
    PartyStatus partyStatus;
    String driver;
    String startPlace;
    String endPlace;
    String price;

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

        public String getDriver() {
            return driver;
        }
        public void setDriver(String driver) {
            this.driver = driver;
        }

        public String getStartPlace() {
            return startPlace;
        }
        public void setStartPlace(String startPlace) {
            this.startPlace = startPlace;
        }

        public String getEndPlace() {
            return endPlace;
        }

        public void setEndPlace(String endPlace) {
            this.endPlace = endPlace;
        }

        public String getPrice() {
            return price;
        }
        public void setPrice(String price) {
            this.price = price;
        }
}
