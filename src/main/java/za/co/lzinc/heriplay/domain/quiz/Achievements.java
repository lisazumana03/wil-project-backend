package za.co.lzinc.heriplay.domain.quiz;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

import java.io.Serializable;

@Entity
public class Achievements implements Serializable {
    @Id
    private String achievementId;
    private String achievementTitle;
    private String description;
    private String achievementMedal;
    @OneToOne
    private Quiz quiz;

    public Achievements() {
    }

    private Achievements(Builder builder){
        this.achievementId = builder.achievementId;
        this.achievementTitle = builder.achievementTitle;
        this.description = builder.description;
        this.achievementMedal = builder.achievementMedal;
        this.quiz = builder.quiz;
    }

    public String getAchievementId() {
        return achievementId;
    }

    public String getAchievementTitle() {
        return achievementTitle;
    }

    public String getDescription() {
        return description;
    }

    public String getAchievementMedal() {
        return achievementMedal;
    }

    public Quiz getQuiz() {
        return quiz;
    }


    public static class Builder{
        private String achievementId;
        private String achievementTitle;
        private String description;
        private String achievementMedal;
        private Quiz quiz;

        public Builder setAchievementId(String achievementId) {
            this.achievementId = achievementId;
            return this;
        }

        public Builder setAchievementTitle(String achievementTitle) {
            this.achievementTitle = achievementTitle;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setAchievementMedal(String achievementMedal) {
            this.achievementMedal = achievementMedal;
            return this;
        }

        public Builder setQuiz(Quiz quiz) {
            this.quiz = quiz;
            return this;
        }

        public Builder copy(Achievements achievements){
            this.achievementId = achievements.achievementId;
            this.achievementTitle = achievements.achievementTitle;
            this.description = achievements.description;
            this.achievementMedal = achievements.achievementMedal;
            this.quiz = achievements.quiz;
            return this;
        }

        public Achievements build(){
            return new Achievements(this);
        }
    }

}
