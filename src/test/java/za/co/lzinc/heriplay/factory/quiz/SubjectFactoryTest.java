package za.co.lzinc.heriplay.factory.quiz;

import org.junit.jupiter.api.Test;
import za.co.lzinc.heriplay.domain.quiz.Quiz;
import za.co.lzinc.heriplay.domain.quiz.Subject;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SubjectFactoryTest {

    @Test
    void registerSubject() {
        int subjectId = 1;
        String subjectName = "Mathematics";
        String subjectCode = "Maths";
        List<Quiz> quizzes = new ArrayList<>();

        Subject subject = SubjectFactory.registerSubject(subjectId, subjectName, subjectCode, quizzes);
        assertNotNull(subject);
    }
}