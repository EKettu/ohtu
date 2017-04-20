package ohtu;

public class TennisGame {

    private int m_score1 = 0;
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;
    private String score;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
        score = "";
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1") {
            m_score1 += 1;
        } else {
            m_score2 += 1;
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
        return (m_score1 == m_score2);
    }

    private String evenScore() {
        switch (m_score1) {
            case 0:
                score = "Love-All";
                break;
            case 1:
                score = "Fifteen-All";
                break;
            case 2:
                score = "Thirty-All";
                break;
            case 3:
                score = "Forty-All";
                break;
            default:
                score = "Deuce";
                break;
        }
        return score;
    }

    private boolean checkIfFourOrOVer() {
        return (m_score1 >= 4 || m_score2 >= 4);
    }

    private String advantageOrWin() {
        int minusResult = m_score1 - m_score2;
        if (minusResult == 1) {
            score = "Advantage player1";
        } else if (minusResult == -1) {
            score = "Advantage player2";
        } else if (minusResult >= 2) {
            score = "Win for player1";
        } else {
            score = "Win for player2";
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
            tempScore = m_score1;
        } else {
            score += "-";
            tempScore = m_score2;
        }
        return tempScore;
    }

    private String setScore(int tempScore) {
        switch (tempScore) {
            case 0:
                score += "Love";
                break;
            case 1:
                score += "Fifteen";
                break;
            case 2:
                score += "Thirty";
                break;
            case 3:
                score += "Forty";
                break;
        }
        return score;
    }

}
