package com.carpool.partyMatch.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;


@Entity
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    Long id;
    String name;
    String gender;
    String curPhoto;
    String partyRole;
    Long customerId;
    Long curPartyId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCurPhoto() {
        return curPhoto;
    }

    public void setCurPhoto(String curPhoto) {
        this.curPhoto = curPhoto;
   }

    public String getPartyRole() {
        return partyRole;
    }

    public void setPartyRole(String partyRole) {
        this.partyRole = partyRole;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getCurPartyId() {
        return curPartyId;
    }

    public void setCurPartyId(Long curPartyId) {
        this.curPartyId = curPartyId;
    }


}
