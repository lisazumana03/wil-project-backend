package za.co.lzinc.heriplay.factory.quiz;

import org.junit.jupiter.api.Test;
import za.co.lzinc.heriplay.domain.quiz.Achievements;

import static org.junit.jupiter.api.Assertions.*;

class AchievementsFactoryTest {

    @Test
    void unlockAchievements() {
        String achievementId = "AL";
        String achievementTitle = "";
        String achievementDescription = "";
        String achievementMedal = "";

        Achievements achievements = AchievementsFactory.unlockAchievements(achievementId, achievementTitle, achievementDescription, achievementMedal);
        assertNotNull(achievements);
    }
}