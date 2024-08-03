package com.first.JobApplication.review.implementation;

import com.first.JobApplication.company.Company;
import com.first.JobApplication.company.CompanyRepository;
import com.first.JobApplication.company.CompanyService;
import com.first.JobApplication.review.Review;
import com.first.JobApplication.review.ReviewRepository;
import com.first.JobApplication.review.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImp implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final CompanyService companyService;

    public ReviewServiceImp(ReviewRepository reviewRepository, CompanyService companyService) {
        this.reviewRepository = reviewRepository;
        this.companyService = companyService;
    }

    @Override
    public List<Review> getAllReviews(Long companyId) {
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);
        return reviews;
    }

    @Override
    public boolean addReview(Long companyId, Review review) {
        Company company = companyService.getCompaniesById(companyId);
        if(null == company){
            return false;
        }
        review.setCompany(company);
        reviewRepository.save(review);
        return true;
    }

    @Override
    public boolean deleteReview(Long reviewId) {
        Review review = getReviewById(reviewId);
        if(null != review){
            reviewRepository.delete(review);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Review getReviewById(Long reviewId){
        Review review = reviewRepository.findById(reviewId).orElse(null);
        if(null != review){
            return review;
        }
        return null;
    }

    @Override
    public Review editReviewById(Long reviewId, Review editableReview) {
        Review existingReview = getReviewById(reviewId);
        if(null != existingReview){
            existingReview.setReviewRating(editableReview.getReviewRating());
            existingReview.setReviewDescription(editableReview.getReviewDescription());
            reviewRepository.save(existingReview);
            return existingReview;
        }
        return null;
    }
}
