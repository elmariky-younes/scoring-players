package fr.younes.scoringplayers.strategy;

import fr.younes.scoringplayers.model.TennisGame;

public class NormalScoringStrategy implements ScoringStrategy {

    @Override
    public void calculateScore(TennisGame game, char pointWinner) {
        if (pointWinner == 'A') {
            if (game.getPlayerAScore() == 30) {
                game.setPlayerAScore(40);
            } else if (game.getPlayerAScore() < 30) {
                game.setPlayerAScore(game.getPlayerAScore() + 15);
            }else if (game.getPlayerAScore() == 40 && game.getPlayerBScore() < 40) {
                game.setAdvantage(true);
                game.setPlayerAScore(50);
            }
        } else if (pointWinner == 'B') {
            if (game.getPlayerBScore() == 30) {
                game.setPlayerBScore(40);
            } else if (game.getPlayerBScore() < 30) {
                game.setPlayerBScore(game.getPlayerBScore() + 15);
            }else if (game.getPlayerBScore() == 40 && game.getPlayerAScore() < 40) {
                game.setAdvantage(true);
                game.setPlayerBScore(50);
            }
        }

        // Transition to Deuce if both players reach 40 points
        if (game.getPlayerAScore() == 40 && game.getPlayerBScore() == 40) {
            game.setDeuce(true);
        }
        }

}


