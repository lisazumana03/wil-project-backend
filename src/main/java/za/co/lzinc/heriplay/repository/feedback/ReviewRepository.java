package za.co.lzinc.heriplay.repository.feedback;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.lzinc.heriplay.domain.feedback.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, String> {
}
