package za.co.lzinc.heriplay.factory.quiz;

import za.co.lzinc.heriplay.domain.quiz.Achievements;

public class AchievementsFactory {
    public static Achievements unlockAchievements(String achievementId, String achievementTitle, String description, String achievementMedal) {
        return new Achievements.Builder()
                .setAchievementId(achievementId)
                .setAchievementTitle(achievementTitle)
                .setDescription(description)
                .setAchievementMedal(achievementMedal)
                .build();
    }
}
