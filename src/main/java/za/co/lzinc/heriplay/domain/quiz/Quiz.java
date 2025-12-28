package za.co.lzinc.heriplay.domain.quiz;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.io.Serializable;
import java.util.List;

@Entity
public class Quiz implements Serializable {
    @Id
    private String id;
    private String title;
    private String category;
    private int timeLimit; // in minutes
    private String description;
    @ManyToOne
    private Subject subject;
    @OneToMany
    private List<Question> questions;

    public Quiz(){
    }

    private Quiz(Builder builder){
        this.id = builder.id;
        this.title = builder.title;
        this.category = builder.category;
        this.timeLimit = builder.timeLimit;
        this.description = builder.description;
        this.subject = builder.subject;
        this.questions = builder.questions;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public int getTimeLimit() {
        return timeLimit;
    }


    public String getDescription() {
        return description;
    }

    public Subject getSubject() {
        return subject;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public static class Builder {
        private String id;
        private String title;
        private String category;
        private int timeLimit; // in minutes
        private String description;
        private Subject subject;
        private List<Question> questions;

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setCategory(String category) {
            this.category = category;
            return this;
        }

        public Builder setTimeLimit(int timeLimit) {
            this.timeLimit = timeLimit;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setSubject(Subject subject) {
            this.subject = subject;
            return this;
        }

        public Builder setQuestions(List<Question> questions) {
            this.questions = questions;
            return this;
        }

        public Builder copy(Quiz quiz){
            this.id = quiz.id;
            this.title = quiz.title;
            this.category = quiz.category;
            this.timeLimit = quiz.timeLimit;
            this.description = quiz.description;
            this.subject = quiz.subject;
            this.questions = quiz.questions;
            return this;
        }

        public Quiz build(){
            return new Quiz(this);
        }
    }
}
