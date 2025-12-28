package za.co.lzinc.heriplay.service.quiz.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import za.co.lzinc.heriplay.domain.quiz.Quiz;
import za.co.lzinc.heriplay.repository.quiz.QuizRepository;
import za.co.lzinc.heriplay.service.quiz.IQuizService;

@Service
public class QuizService implements IQuizService {

    @Autowired
    private QuizRepository quizRepository;

    @Override
    public Quiz create(Quiz quiz) {
        if (quiz.getId() == null || quiz.getId().isBlank()) {
            quiz.setId(UUID.randomUUID().toString());
        }
        return quizRepository.save(quiz);
    }

    @Override
    public List<Quiz> readAll() {
        return quizRepository.findAll();
    }

    @Override
    public Quiz readById(String s) {
        return quizRepository.findById(s).orElse(null);
    }

    @Override
    public Quiz update(Quiz quiz) {
        return quizRepository.save(quiz);
    }


    @Override
    public void delete(String quizId) {
        quizRepository.deleteById(quizId);
    }
}
