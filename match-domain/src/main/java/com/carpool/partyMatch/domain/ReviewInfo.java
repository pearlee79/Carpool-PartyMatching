package com.carpool.partyMatch.domain;

import javax.persistence.Embeddable;

@Embeddable
public class ReviewInfo {

    Long reviewAverageScore;
    String recentComment;

    public Long getReviewAverageScore() {
        return reviewAverageScore;
    }
    public void setReviewAverageScore(Long reviewAverageScore) {
        this.reviewAverageScore = reviewAverageScore;
    }
    public String getRecentComment() {
        return recentComment;
    }
    public void setRecentComment(String recentComment) {
        this.recentComment = recentComment;
    }


}
