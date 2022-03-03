package uk.co.zenitech.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uk.co.zenitech.core.model.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
