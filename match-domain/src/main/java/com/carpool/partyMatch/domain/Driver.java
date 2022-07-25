package com.carpool.partyMatch.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;


@Embeddable
public class Driver {

    Long userId;
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

}
