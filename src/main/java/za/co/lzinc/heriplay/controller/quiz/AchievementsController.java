package za.co.lzinc.heriplay.controller.quiz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import za.co.lzinc.heriplay.service.quiz.impl.AchievementsService;

@RestController
@RequestMapping("/api/achievements")
@CrossOrigin(origins = {"http://localhost:4516", "http://172.20.10.9:4516"})
public class AchievementsController {
    @Autowired
    private AchievementsService achievementsService;

    @PreAuthorize("hasRole('USER')")
    @PostMapping("/unlock")
    public ResponseEntity<String> unlockAchievement(@RequestParam String userId, @RequestParam String achievementId) {
        achievementsService.unlockAchievement(userId, achievementId);
        return ResponseEntity.ok("Achievement unlocked successfully");
    }
}