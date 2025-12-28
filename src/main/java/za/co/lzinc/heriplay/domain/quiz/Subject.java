package za.co.lzinc.heriplay.domain.quiz;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.*;
import za.co.lzinc.heriplay.domain.authentication.User;

@Entity
public class Subject implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int subjectId;
    private String subjectName;
    private String subjectCode;
    private String description;
    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Quiz> quizzes;
    @ManyToOne
    private User createdBy;

    public Subject(){}

    private Subject(Builder builder){
        this.subjectId = builder.subjectId;
        this.subjectName = builder.subjectName;
        this.subjectCode = builder.subjectCode;
        this.description = builder.description;
        this.quizzes = builder.quizzes;
        this.createdBy = builder.createdBy;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public String getDescription() {
        return description;
    }

    public List<Quiz> getQuizzes() {
        return quizzes;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subjectId=" + subjectId +
                ", subjectName='" + subjectName + '\'' +
                ", subjectCode='" + subjectCode + '\'' +
                ", description='" + description + '\'' +
                ", quizzes=" + quizzes +
                ", createdBy=" + createdBy +
                '}';
    }

    public static class Builder{
        private int subjectId;
        private String subjectName;
        private String subjectCode;
        private String description;
        private List<Quiz> quizzes;
        private User createdBy;

        public Builder setSubjectId(int subjectId){
            this.subjectId = subjectId;
            return this;
        }

        public Builder setSubjectName(String subjectName){
            this.subjectName = subjectName;
            return this;
        }

        public Builder setSubjectCode(String subjectCode){
            this.subjectCode = subjectCode;
            return this;
        }

        public Builder setDescription(String description){
            this.description = description;
            return this;
        }

        public Builder setQuizzes(List<Quiz> quizzes){
            this.quizzes = quizzes;
            return this;
        }

        public Builder setCreatedBy(User createdBy){
            this.createdBy = createdBy;
            return this;
        }


        public Builder copy(Subject subject){
            this.subjectId = subject.subjectId;
            this.subjectName = subject.subjectName;
            this.subjectCode = subject.subjectCode;
            this.description = subject.description;
            this.quizzes = subject.quizzes;
            this.createdBy = subject.createdBy;
            return this;
        }

        public Subject build(){
            return new Subject (this);
        }
    }
}
