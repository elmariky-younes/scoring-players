package fr.younes.scoringplayers.strategy;

import fr.younes.scoringplayers.model.TennisGame;

public class DeuceScoringStrategy implements ScoringStrategy {

    @Override
    public void calculateScore(TennisGame game, char pointWinner) {
        game.setAdvantage(true);
        game.setDeuce(false);

        if (pointWinner == 'A') {
            game.setAdvantagePlayer("A");
        } else if (pointWinner == 'B') {
            game.setAdvantagePlayer("B");
        }
    }
}

