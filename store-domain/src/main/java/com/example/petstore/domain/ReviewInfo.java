package com.example.petstore.domain;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

//Aggregate Root
@Entity
public class ReviewInfo {
    @Id
    Long id;
    Long customerId;
    Long reviewScore;
    String comment;
    Long reviewId;
    
    public Long getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }
    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getReviewScore() {
        return reviewScore;
    }
    public void setReviewScore(Long reviewScore) {
        this.reviewScore = reviewScore;
    }

    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }

    public Long getReviewId() {
        return reviewId;
    }
    public void setReviewId(Long reviewId) {
        this.reviewId = reviewId;
    }

    

}
