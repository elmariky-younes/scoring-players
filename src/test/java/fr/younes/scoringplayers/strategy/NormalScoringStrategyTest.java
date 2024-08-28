package fr.younes.scoringplayers.strategy;


import fr.younes.scoringplayers.model.TennisGame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NormalScoringStrategyTest {

    private NormalScoringStrategy regularScoringStrategy;
    private TennisGame game;

    @BeforeEach
    public void setUp() {
        regularScoringStrategy = new NormalScoringStrategy();
        game = new TennisGame();
    }

    @Test
    public void testPlayerAScoresFirstPoint() {
        regularScoringStrategy.calculateScore(game, 'A');
        assertEquals(15, game.getPlayerAScore());
        assertEquals(0, game.getPlayerBScore());
    }

    @Test
    public void testPlayerBScoresFirstPoint() {
        regularScoringStrategy.calculateScore(game, 'B');
        assertEquals(0, game.getPlayerAScore());
        assertEquals(15, game.getPlayerBScore());
    }

    @Test
    public void testPlayerAReaches40() {
        game.setPlayerAScore(30);
        regularScoringStrategy.calculateScore(game, 'A');
        assertEquals(40, game.getPlayerAScore());
        assertEquals(0, game.getPlayerBScore());
    }

    @Test
    public void testDeuceTriggeredWhenBothReach40() {
        game.setPlayerAScore(30);
        game.setPlayerBScore(30);
        regularScoringStrategy.calculateScore(game, 'A');
        regularScoringStrategy.calculateScore(game, 'B');
        assertEquals(40, game.getPlayerAScore());
        assertEquals(40, game.getPlayerBScore());
        assertEquals(true, game.isDeuce());
    }
}
