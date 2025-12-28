package za.co.lzinc.heriplay.dto.quiz;

import java.util.Map;

public class QuizAttemptRequest {
    private String quizId;
    private Map<Long, String> answers; // questionId → answer
}

