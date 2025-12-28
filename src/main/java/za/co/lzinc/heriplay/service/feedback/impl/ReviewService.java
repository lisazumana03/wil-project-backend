package za.co.lzinc.heriplay.service.feedback.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.lzinc.heriplay.domain.feedback.Review;
import za.co.lzinc.heriplay.repository.feedback.ReviewRepository;
import za.co.lzinc.heriplay.service.feedback.IReviewService;

import java.util.List;

@Service
public class ReviewService implements IReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public void delete(String reviewId) {
        reviewRepository.deleteById(reviewId);
    }

    @Override
    public Review create(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public List<Review> readAll() {
        return reviewRepository.findAll();
    }

    @Override
    public Review readById(String s) {
        return null;
    }

    @Override
    public Review update(Review review) {
        if(review.getReviewId()>0){
            return reviewRepository.save(review);
        }
        return null;
    }
}
