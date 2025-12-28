package za.co.lzinc.heriplay.controller.quiz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import za.co.lzinc.heriplay.domain.quiz.Quiz;
import za.co.lzinc.heriplay.service.quiz.impl.QuizService;

@RestController
@RequestMapping("/api/quiz")
@CrossOrigin(origins = {"http://localhost:4516", "http://172.20.10.9:4516"})
public class QuizController {
    @Autowired
    private QuizService quizService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<Quiz> createQuiz(@RequestBody Quiz quiz) {
        Quiz createdQuiz = quizService.create(quiz);
        return ResponseEntity.ok(createdQuiz);
    }

    @GetMapping
    public ResponseEntity<List<Quiz>> getAll(){
        List<Quiz> quizzes = quizService.readAll();
        return ResponseEntity.ok(quizzes);
    }

    @GetMapping("/{quizId}")
    public ResponseEntity<Quiz> getById(@PathVariable String quizId){
        Quiz quiz = quizService.readById(quizId);
        if (quiz == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(quiz);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{quizId}")
    public ResponseEntity<Void>deleteQuiz(@PathVariable String quizId) {
        quizService.delete(quizId);
        return ResponseEntity.noContent().build();
    }
    
}
