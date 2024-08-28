package fr.younes.scoringplayers.strategy;

import fr.younes.scoringplayers.model.TennisGame;

public class AdvantageScoringStrategy implements ScoringStrategy {

    @Override
    public void calculateScore(TennisGame game, char pointWinner) {
        if (game.getAdvantagePlayer().equals(String.valueOf(pointWinner))) {
            if (pointWinner == 'A') {
                game.setPlayerAScore(50); // Indicates Player A wins
            } else if (pointWinner == 'B') {
                game.setPlayerBScore(50); // Indicates Player B wins
            }
            game.setAdvantage(false);
        } else {
            // If the other player wins the point, return to deuce
            game.setDeuce(true);
            game.setAdvantage(false);
        }
    }
}



