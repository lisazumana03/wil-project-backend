package za.co.lzinc.heriplay.service.quiz;

public interface IAchievementsService {
    void unlockAchievement(String userId,String achievementId);
    void deleteAchievement(String achievementId);
}
