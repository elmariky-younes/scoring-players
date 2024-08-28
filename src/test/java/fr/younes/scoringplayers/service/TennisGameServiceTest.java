package fr.younes.scoringplayers.service;

import fr.younes.scoringplayers.service.impl.TennisGameServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TennisGameServiceTest {

    private TennisGameService tennisGameService;

    @BeforeEach
    public void setUp() {
        tennisGameService = new TennisGameServiceImpl();
    }

    @Test
    public void testRegularScoring_PlayerAWinsWithoutDeuce() {
        String input = "AAAA"; // Player A wins with 40:0
        String expectedOutput = "Player A: 15 / Player B: 0\n" +
                "Player A: 30 / Player B: 0\n" +
                "Player A: 40 / Player B: 0\n" +
                "Player A wins the game\n";
        assertEquals(expectedOutput, tennisGameService.processGame(input));
    }

    @Test
    public void testRegularScoring_PlayerBWinsWithoutDeuce() {
        String input = "BBBB"; // Player B wins with 0:40
        String expectedOutput = "Player A: 0 / Player B: 15\n" +
                "Player A: 0 / Player B: 30\n" +
                "Player A: 0 / Player B: 40\n" +
                "Player B wins the game\n";
        assertEquals(expectedOutput, tennisGameService.processGame(input));
    }

    @Test
    public void testDeuceAndAdvantageScenario() {
        String input = "ABABABABAA"; // Leads to deuce, Player A wins
        String expectedOutput = "Player A: 15 / Player B: 0\n" +
                "Player A: 15 / Player B: 15\n" +
                "Player A: 30 / Player B: 15\n" +
                "Player A: 30 / Player B: 30\n" +
                "Player A: 40 / Player B: 30\n" +
                "Player A: 40 / Player B: 40\n" +
                "Player A: Advantage / Player B: 40\n" +
                "Player A: 40 / Player B: 40\n" +
                "Player A: Advantage / Player B: 40\n" +
                "Player A wins the game";

        List<String> expectedOutputList = Arrays.asList(expectedOutput.split("\n"));
        assertTrue(tennisGameService.processGame(input).contains("Player A: Advantage"));

    }

    @Test
    public void testDeuceAndAdvantageScenario_PlayerBWins() {
        String input = "ABABABABBB"; // Leads to deuce, Player B wins
        String expectedOutput = "Player A: 15 / Player B: 0\n" +
                "Player A: 15 / Player B: 15\n" +
                "Player A: 30 / Player B: 15\n" +
                "Player A: 30 / Player B: 30\n" +
                "Player A: 40 / Player B: 30\n" +
                "Player A: 40 / Player B: 40\n" +
                "Player A: Advantage / Player B: 40\n" +
                "Player A: 40 / Player B: 40\n" +
                "Player A: 40 / Player B: Advantage\n" +
                "Player B wins the game";


        assertTrue(tennisGameService.processGame(input).contains("Player A: Advantage"));

    }

    @Test
    public void testNoDeuce_PlayerAWinsStraight() {
        String input = "ABABAAA"; // Player A wins without deuce
        String expectedOutput = "Player A: 15 / Player B: 0\n" +
                "Player A: 15 / Player B: 15\n" +
                "Player A: 30 / Player B: 15\n" +
                "Player A: 30 / Player B: 30\n" +
                "Player A: 40 / Player B: 30\n" +
                "Player A wins the game\n";
        assertEquals(expectedOutput, tennisGameService.processGame(input));
    }

    @Test
    public void testLongDeuceScenario() {
        String input = "ABABABABABABABA"; // Several deuce rounds, Player A wins
        String expectedOutput = "Player A: 15 / Player B: 0\n" +
                "Player A: 15 / Player B: 15\n" +
                "Player A: 30 / Player B: 15\n" +
                "Player A: 30 / Player B: 30\n" +
                "Player A: 40 / Player B: 30\n" +
                "Player A: 40 / Player B: 40\n" +
                "Player A: Advantage / Player B: 40\n" +
                "Player A: 40 / Player B: 40\n" +
                "Player A: Advantage / Player B: 40\n" +
                "Player A wins the game\n";
        assertTrue(tennisGameService.processGame(input).contains("Player A: Advantage"));

    }
}
