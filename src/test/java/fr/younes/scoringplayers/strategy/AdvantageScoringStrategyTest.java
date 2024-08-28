package fr.younes.scoringplayers.strategy;

import fr.younes.scoringplayers.model.TennisGame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AdvantageScoringStrategyTest {

    private AdvantageScoringStrategy advantageScoringStrategy;
    private TennisGame game;

    @BeforeEach
    public void setUp() {
        advantageScoringStrategy = new AdvantageScoringStrategy();
        game = new TennisGame();
        game.setPlayerAScore(40);
        game.setPlayerBScore(40);
        game.setAdvantage(true);
        game.setAdvantagePlayer("A");
    }

    @Test
    public void testPlayerAWinsFromAdvantage() {
        advantageScoringStrategy.calculateScore(game, 'A');
        assertEquals(50, game.getPlayerAScore());
        assertEquals(false, game.isAdvantage());
    }

    @Test
    public void testPlayerBReturnsToDeuce() {
        advantageScoringStrategy.calculateScore(game, 'B');
        assertEquals(40, game.getPlayerAScore());
        assertEquals(40, game.getPlayerBScore());
        assertEquals(true, game.isDeuce());
        assertEquals(false, game.isAdvantage());
    }
}

