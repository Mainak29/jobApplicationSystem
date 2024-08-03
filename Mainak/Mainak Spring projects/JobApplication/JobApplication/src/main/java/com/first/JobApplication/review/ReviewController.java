package com.first.JobApplication.review;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/reviews")
    private ResponseEntity<List<Review>> getAllReview(@PathVariable Long companyId){
        return new ResponseEntity<>(reviewService.getAllReviews(companyId), HttpStatus.OK);

    }

    @PostMapping("/reviews")
    private ResponseEntity<String> addReview(@PathVariable Long companyId, @RequestBody Review review){
        if(reviewService.addReview(companyId,review)){
            return new ResponseEntity<>("Review added",HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Company ID not found, So couldn't add the review",HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/reviews/{reviewId}")
    private ResponseEntity<String> deleteReview(@PathVariable Long reviewId){
        if(reviewService.deleteReview(reviewId)){
            return new ResponseEntity<>("Review deleted",HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Review Id not found, So couldn't delete the review",HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/reviews/{reviewId}")
    private ResponseEntity<Review> getReviewById(@PathVariable Long reviewId){
        Review review = reviewService.getReviewById(reviewId);
        if(null != review){
            return new ResponseEntity<>(review,HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/reviews/{reviewId}")
    private ResponseEntity<Review> editReviewById(@PathVariable Long reviewId, @RequestBody Review editableReview){
       Review updatedReview = reviewService.editReviewById(reviewId,editableReview);
       if(updatedReview == null){
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }else
           return new ResponseEntity<>(updatedReview,HttpStatus.OK);
    }
}
