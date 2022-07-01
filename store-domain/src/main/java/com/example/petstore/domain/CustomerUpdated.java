package com.example.petstore.domain;

import com.example.petstore.domain.PetReserved;

public class CustomerUpdated extends AbstractEvent{
    Long id;
    String name;
    String gender;
    String curPhoto;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {this.id = id;}

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

}
