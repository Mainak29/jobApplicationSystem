package com.first.JobApplication.review;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.first.JobApplication.company.Company;
import jakarta.persistence.*;

@Entity
public class Review {


    public Review() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;
    private Long reviewRating;
    private String reviewDescription;

    @JsonIgnore
    @ManyToOne
    private Company company;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Review(Long reviewId, Long reviewRating, String reviewDescription) {
        this.reviewId = reviewId;
        this.reviewRating = reviewRating;
        this.reviewDescription = reviewDescription;
    }

    public Long getReviewId() {
        return reviewId;
    }

    public void setReviewId(Long reviewId) {
        this.reviewId = reviewId;
    }

    public Long getReviewRating() {
        return reviewRating;
    }

    public void setReviewRating(Long reviewRating) {
        this.reviewRating = reviewRating;
    }

    public String getReviewDescription() {
        return reviewDescription;
    }

    public void setReviewDescription(String reviewDescription) {
        this.reviewDescription = reviewDescription;
    }
}
