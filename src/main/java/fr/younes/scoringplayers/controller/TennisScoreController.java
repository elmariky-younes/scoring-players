package fr.younes.scoringplayers.controller;

import fr.younes.scoringplayers.service.TennisGameService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tennis")
public class TennisScoreController {


    private final TennisGameService tennisGameService;

    public TennisScoreController(TennisGameService tennisScoreService) {
        this.tennisGameService = tennisScoreService;
    }

    @PostMapping("/play")
    public ResponseEntity<String> playGame(@RequestBody String input) {
        String result = tennisGameService.processGame(input);
        return ResponseEntity.ok(result);
    }
}

