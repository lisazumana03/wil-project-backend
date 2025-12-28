package za.co.lzinc.heriplay.service.quiz;

import za.co.lzinc.heriplay.domain.quiz.Question;
import za.co.lzinc.heriplay.service.IService;

public interface IQuestionService extends IService<Question, Integer> {
    void delete(int questionId);
}
