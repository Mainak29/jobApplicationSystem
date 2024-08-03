package com.first.JobApplication.review;

import java.util.List;

public interface ReviewService {

    List<Review> getAllReviews(Long companyId);

    boolean addReview(Long companyId, Review review);

    boolean deleteReview(Long reviewId);

    Review getReviewById(Long reviewId);

    Review editReviewById(Long reviewId,Review editableReview);
}
