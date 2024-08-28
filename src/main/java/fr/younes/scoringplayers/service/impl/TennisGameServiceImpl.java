package fr.younes.scoringplayers.service.impl;

import fr.younes.scoringplayers.strategy.AdvantageScoringStrategy;
import fr.younes.scoringplayers.strategy.DeuceScoringStrategy;
import fr.younes.scoringplayers.strategy.NormalScoringStrategy;
import fr.younes.scoringplayers.strategy.ScoringStrategy;
import fr.younes.scoringplayers.model.TennisGame;
import fr.younes.scoringplayers.service.TennisGameService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class TennisGameServiceImpl implements TennisGameService {

    private final Map<String, ScoringStrategy> strategies = new HashMap<>();

    public TennisGameServiceImpl() {
        strategies.put("regular", new NormalScoringStrategy());
        strategies.put("deuce", new DeuceScoringStrategy());
        strategies.put("advantage", new AdvantageScoringStrategy());
    }
    @Override
    public String processGame(String input) {
        TennisGame game = new TennisGame();
        StringBuilder result = new StringBuilder();

        for (char c : input.toCharArray()) {
            ScoringStrategy strategy = determineStrategy(game);
            strategy.calculateScore(game, c);
            if(game.getPlayerAScore() < 50 && game.getPlayerBScore() < 50) {
                result.append(formatScore(game)).append("\n");
            }

            if (checkForWinner(game)) {
                result.append(determineWinner(game)).append("\n");
                break;  // End the game as we have a winner
            }
        }

        return result.toString();
    }

    private boolean checkForWinner(TennisGame game) {
        if (game.getPlayerAScore() == 50 || game.getPlayerBScore() == 50) {
            return true;
        }
        return false;
    }

    private String determineWinner(TennisGame game) {
        if (game.getPlayerAScore() == 50) {
            return "Player A wins the game";
        } else if (game.getPlayerBScore() == 50) {
            return "Player B wins the game";
        }
        return "No winner yet";
    }

    private String formatScore(TennisGame game) {
        if (game.isDeuce()) {
            return "Player A: 40 / Player B: 40";
        } else if (game.isAdvantage()) {
            return "Player A: " + (game.getAdvantagePlayer().equals("A") ? "Advantage" : "40") +
                    " / Player B: " + (game.getAdvantagePlayer().equals("B") ? "Advantage" : "40");
        }

        return String.format("Player A: %d / Player B: %d", game.getPlayerAScore(), game.getPlayerBScore());
    }

    private ScoringStrategy determineStrategy(TennisGame game) {
        if (game.isAdvantage()) {
            return strategies.get("advantage");
        } else if (game.isDeuce()) {
            return strategies.get("deuce");
        } else {
            return strategies.get("regular");
        }
    }






}

