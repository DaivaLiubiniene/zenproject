package uk.co.zenitech.core.service;

import org.springframework.stereotype.Service;
import uk.co.zenitech.core.model.Review;
import uk.co.zenitech.core.repository.ReviewRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) { this.reviewRepository = reviewRepository; }

    @Transactional
    public Review getReviewById(Long id) {
        return reviewRepository.getById(id);
    }

    @Transactional
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    @Transactional
    public Review addReview(Review review) {
        return reviewRepository.save(review);
    }

    @Transactional
    public void deleteReviewById(Long id) {
        reviewRepository.deleteById(id);
    }
}
