package ohtu;

import java.util.HashMap;
import java.util.Map;

public class TennisGame {

    private int player1_score = 0;
    private int player2_score = 0;
    private String player1Name;
    private String player2Name;
    private String score;
    private Map<Integer, String> scores;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
        score = "";
        scores = new HashMap<>();
        scores.put(0, "Love");
        scores.put(1, "Fifteen");
        scores.put(2, "Thirty");
        scores.put(3, "Forty");
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1") {
            player1_score += 1;
        } else {
            player2_score += 1;
        }
    }

    public String getScore() {
        if (checkIfEven()) {
            score = evenScore();
        } else if (checkIfFourOrOVer()) {
            score = advantageOrWin();
        } else {
            score = otherCases();
        }
        return score;
    }

    private boolean checkIfEven() {
        return (player1_score == player2_score);
    }

    private String evenScore() {
        if (0 <= player1_score && player1_score < 4) {
            score = scores.get(player1_score) + "-All";
        } else {
            score = "Deuce";
        }
        return score;
    }

    private boolean checkIfFourOrOVer() {
        return (player1_score >= 4 || player2_score >= 4);
    }

    private String advantageOrWin() {
        int minusResult = player1_score - player2_score;
        if (minusResult == 1) {
            score = "Advantage " + player1Name;
        } else if (minusResult == -1) {
            score = "Advantage " + player2Name;;
        } else if (minusResult >= 2) {
            score = "Win for " + player1Name;
        } else {
            score = "Win for " + player2Name;;
        }
        return score;
    }

    private String otherCases() {
        int tempScore = 0;
        for (int i = 1; i < 3; i++) {
            tempScore = setTempScore(i, tempScore);
            score = setScore(tempScore);
        }
        return score;
    }

    private int setTempScore(int index, int tempScore) {
        if (index == 1) {
            tempScore = player1_score;
        } else {
            score += "-";
            tempScore = player2_score;
        }
        return tempScore;
    }

    private String setScore(int tempScore) {
        score += scores.get(tempScore);
        return score;
    }

}
