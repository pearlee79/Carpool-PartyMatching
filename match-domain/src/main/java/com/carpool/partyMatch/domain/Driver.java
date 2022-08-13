package com.carpool.partyMatch.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;


@Embeddable
public class Driver {

    Long driverId;
    String name;

    protected Driver(){}
    public Driver(Long driverId, String name){
        this.driverId = driverId;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Long getDriverId() {
        return driverId;
    }


}
