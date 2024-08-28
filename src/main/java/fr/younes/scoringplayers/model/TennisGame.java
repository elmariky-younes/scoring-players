package fr.younes.scoringplayers.model;

public class TennisGame {
    private int playerAScore;
    private int playerBScore;
    private boolean isDeuce;
    private boolean isAdvantage;
    private String advantagePlayer;

    public TennisGame() {
        this.playerAScore = 0;
        this.playerBScore = 0;
        this.isDeuce = false;
        this.isAdvantage = false;
        this.advantagePlayer = "";
    }

    // Getters and setters...
    public int getPlayerAScore() {
        return playerAScore;
    }

    public void setPlayerAScore(int playerAScore) {
        this.playerAScore = playerAScore;
    }

    public int getPlayerBScore() {
        return playerBScore;
    }

    public void setPlayerBScore(int playerBScore) {
        this.playerBScore = playerBScore;
    }

    public boolean isDeuce() {
        return isDeuce;
    }

    public void setDeuce(boolean deuce) {
        isDeuce = deuce;
    }

    public boolean isAdvantage() {
        return isAdvantage;
    }

    public void setAdvantage(boolean advantage) {
        isAdvantage = advantage;
    }

    public String getAdvantagePlayer() {
        return advantagePlayer;
    }

    public void setAdvantagePlayer(String advantagePlayer) {
        this.advantagePlayer = advantagePlayer;
    }
}

