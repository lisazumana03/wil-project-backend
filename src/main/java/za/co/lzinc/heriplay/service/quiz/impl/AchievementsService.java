package za.co.lzinc.heriplay.service.quiz.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import za.co.lzinc.heriplay.repository.quiz.AchievementRepository;
import za.co.lzinc.heriplay.service.quiz.IAchievementsService;  

@Service
public class AchievementsService implements IAchievementsService {
    @Autowired
    private AchievementRepository achievementRepository;

    @Override
    public void unlockAchievement(String userId, String achievementId) {
        // Implementation logic to unlock the achievement for the user
    }

    @Override
    public void deleteAchievement(String achievementId) {

    }

    public void assignAchievementBasedOnScore(String userId, int score) {
        String achievementId;
        if (score >= 100) {
            achievementId = "GOLD";
        } else if (score >= 75) {
            achievementId = "SILVER";
        } else if (score >= 50) {
            achievementId = "BRONZE";
        } else {
            return; // No achievement for scores below 50
        }
        unlockAchievement(userId, achievementId);
    }
}