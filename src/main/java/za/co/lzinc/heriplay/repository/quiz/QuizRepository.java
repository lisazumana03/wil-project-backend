package za.co.lzinc.heriplay.repository.quiz;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.lzinc.heriplay.domain.quiz.Quiz;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, String> {
}
