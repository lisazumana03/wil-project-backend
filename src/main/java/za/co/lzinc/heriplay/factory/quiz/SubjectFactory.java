package za.co.lzinc.heriplay.factory.quiz;

import za.co.lzinc.heriplay.domain.quiz.Quiz;
import za.co.lzinc.heriplay.domain.quiz.Subject;

import java.util.List;

public class SubjectFactory {
    public static Subject registerSubject(int subjectId, String subjectName, String subjectCode, List<Quiz>quizzes) {
        return new Subject.Builder()
                .setSubjectId(subjectId)
                .setSubjectName(subjectName)
                .setSubjectCode(subjectCode)
                .setQuizzes(quizzes)
                .build();
    }
}
