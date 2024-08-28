package fr.younes.scoringplayers.strategy;

import fr.younes.scoringplayers.model.TennisGame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeuceScoringStrategyTest {

    private DeuceScoringStrategy deuceScoringStrategy;
    private TennisGame game;

    @BeforeEach
    public void setUp() {
        deuceScoringStrategy = new DeuceScoringStrategy();
        game = new TennisGame();
        game.setPlayerAScore(40);
        game.setPlayerBScore(40);
        game.setDeuce(true);
    }

    @Test
    public void testPlayerAGainsAdvantage() {
        deuceScoringStrategy.calculateScore(game, 'A');
        assertEquals("A", game.getAdvantagePlayer());
        assertEquals(true, game.isAdvantage());
        assertEquals(false, game.isDeuce());
    }

    @Test
    public void testPlayerBGainsAdvantage() {
        deuceScoringStrategy.calculateScore(game, 'B');
        assertEquals("B", game.getAdvantagePlayer());
        assertEquals(true, game.isAdvantage());
        assertEquals(false, game.isDeuce());
    }
}
