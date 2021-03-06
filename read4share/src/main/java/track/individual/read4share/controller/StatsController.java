package track.individual.read4share.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import track.individual.read4share.dto.response.GlobalStatsResponse;
import track.individual.read4share.repository.AdvRepo;
import track.individual.read4share.repository.ChatRepo;
import track.individual.read4share.repository.UserRepo;

@CrossOrigin(origins = "http://localhost:4200")
@RestController()
@RequestMapping("/api/stats")
@RequiredArgsConstructor
public class StatsController {

    private final AdvRepo advRepo;
    private final UserRepo userRepo;
    private final ChatRepo chatRepo;

    @GetMapping("/global")
    public ResponseEntity<GlobalStatsResponse> getStats() {
        int totalUsers = userRepo.getTotalNumber();
        int activeAdvs = advRepo.getActiveAdv();

        return ResponseEntity.ok().body(GlobalStatsResponse.builder()
                .activeAdvs(activeAdvs)
                .lastMonthAdvs(advRepo.getLastMonthPublished())
                .userAverageAdv((double) activeAdvs / totalUsers)
                .totalUsers(totalUsers)
                .totalChats(chatRepo.getTotalChats()).build());
    }
}
