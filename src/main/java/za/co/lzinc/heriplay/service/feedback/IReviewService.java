package za.co.lzinc.heriplay.service.feedback;

import za.co.lzinc.heriplay.domain.feedback.Review;
import za.co.lzinc.heriplay.service.IService;

public interface IReviewService extends IService<Review, String> {
    void delete(String reviewId);
}
