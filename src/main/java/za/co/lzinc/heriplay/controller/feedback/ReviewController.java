package za.co.lzinc.heriplay.controller.feedback;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import za.co.lzinc.heriplay.domain.feedback.Review;
import za.co.lzinc.heriplay.service.feedback.impl.ReviewService;

@RestController
@RequestMapping("/api/review")
@CrossOrigin(origins = {"http://localhost:4516", "http://172.20.10.9:4516"})
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @PostMapping
    public ResponseEntity<Review> create(@RequestBody Review review) {
        if (review.getUser() == null || review.getUser().getUserId() <= 0) {
            return ResponseEntity.badRequest().body(null); // Ensure userId is not null
        }
        Review createdReview = reviewService.create(review);
        return ResponseEntity.ok(createdReview);
    }

    @GetMapping
    public ResponseEntity<List<Review>> getAllReviews() {
        return new ResponseEntity<>(reviewService.readAll(), HttpStatus.OK);
    }
}
