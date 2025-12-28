package za.co.lzinc.heriplay.factory.feedback;

import za.co.lzinc.heriplay.domain.feedback.Review;

public class ReviewFactory {
    public static Review submitReview(int reviewId, String description, int rating){
        return new Review.Builder()
                .setReviewId(reviewId)
                .setDescription(description)
                .setRating(rating)
                .build();
    }
}
