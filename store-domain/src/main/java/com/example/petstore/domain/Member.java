package com.example.petstore.domain;

import java.io.Serializable;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;


@Entity
public class Member {
    
    @Id @GeneratedValue
    Long id;
    String name;
    String gender;
    String curPhoto;
    String partyRole;
    Long customerId;
    Long curPartyId;
    MemberStatus memberStatus;

    @Embedded
    Money price;

    public String getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getCurPhoto() {
        return curPhoto;
    }

    public void setCurPhoto(Money curPhoto) {
        this.curPhoto = curPhoto;
   }

    public String getPartyRole() {
        return partyRole;
    }

    public void setPartyRole(int partyRole) {
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
