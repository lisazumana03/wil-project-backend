package za.co.lzinc.heriplay.service.quiz;

import za.co.lzinc.heriplay.domain.quiz.Quiz;
import za.co.lzinc.heriplay.service.IService;

public interface IQuizService extends IService<Quiz, String> {
    void delete(String quizId);
}
