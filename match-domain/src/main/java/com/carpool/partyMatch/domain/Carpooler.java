package com.carpool.partyMatch.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;


@Embeddable
public class Carpooler {

    Long userId;
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

}
