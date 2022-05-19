package uk.co.zenitech.core.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.co.zenitech.core.model.Review;
import uk.co.zenitech.core.service.ReviewService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) { this.reviewService = reviewService; }

    @GetMapping("/{id}")
    public ResponseEntity<Review> getReviewById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(reviewService.getReviewById(id));
    }

    @GetMapping
    public ResponseEntity<List<Review>> getAllReviews() {
        return ResponseEntity.status(HttpStatus.OK).body(reviewService.getAllReviews());
    }

    @PostMapping
    public ResponseEntity<Review> addReview(@RequestBody @Valid Review review) {
        return ResponseEntity.status(HttpStatus.CREATED).body(reviewService.addReview(review));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteReviewById(@PathVariable Long id) {
        reviewService.deleteReviewById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
