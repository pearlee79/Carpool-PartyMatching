package com.example.petstore.domain;
import com.example.petstore.AbstractEvent;

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

}
