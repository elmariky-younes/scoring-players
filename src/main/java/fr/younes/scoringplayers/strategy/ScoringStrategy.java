package fr.younes.scoringplayers.strategy;

import fr.younes.scoringplayers.model.TennisGame;

public interface ScoringStrategy {
    void calculateScore(TennisGame game, char pointWinner);
}

