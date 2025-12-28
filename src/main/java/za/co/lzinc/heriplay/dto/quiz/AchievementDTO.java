package za.co.lzinc.heriplay.dto.quiz;

import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import za.co.lzinc.heriplay.domain.quiz.Quiz;

public class AchievementDTO {
    private String achievementId;
    private String achievementTitle;
    private String description;
    private String achievementMedal;
    private Quiz quiz;

    public AchievementDTO() {
    }

    public AchievementDTO(AchievementDTO achievementDTO) {
        this.achievementId = achievementDTO.achievementId;
        this.achievementTitle = achievementDTO.achievementTitle;
        this.description = achievementDTO.description;
        this.achievementMedal = achievementDTO.achievementMedal;
        this.quiz = achievementDTO.quiz;
    }

    public String getAchievementId() {
        return achievementId;
    }

    public void setAchievementId(String achievementId) {
        this.achievementId = achievementId;
    }

    public String getAchievementTitle() {
        return achievementTitle;
    }

    public void setAchievementTitle(String achievementTitle) {
        this.achievementTitle = achievementTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAchievementMedal() {
        return achievementMedal;
    }

    public void setAchievementMedal(String achievementMedal) {
        this.achievementMedal = achievementMedal;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    @Override
    public String toString() {
        return "AchievementDTO{" +
                "achievementId='" + achievementId + '\'' +
                ", achievementTitle='" + achievementTitle + '\'' +
                ", description='" + description + '\'' +
                ", achievementMedal='" + achievementMedal + '\'' +
                ", quiz=" + quiz +
                '}';
    }
}
