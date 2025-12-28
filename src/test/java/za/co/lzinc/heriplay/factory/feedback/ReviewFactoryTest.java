package za.co.lzinc.heriplay.factory.feedback;

import org.junit.jupiter.api.Test;
import za.co.lzinc.heriplay.domain.feedback.Review;

import static org.junit.jupiter.api.Assertions.*;

class ReviewFactoryTest {

    @Test
    void submitReview() {
        int reviewId = 5;
        String description = "desc";
        int rating = 100;

        Review review = ReviewFactory.submitReview(reviewId, description, rating);
        assertNotNull(review);
    }
}