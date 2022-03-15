package edu.ntnu.idatt1002.k103.tournament.javaObjects;

/**
 * The type Score.
 */
public class Score {
    private final int[] scoreOfPlayer1;
    private final int[] scoreOfPlayer2;

    /**
     * Instantiates a new Score.
     *
     * @param scoreOfPlayer1 the score of player 1
     * @param scoreOfPlayer2 the score of player 2
     */
    public Score(int[] scoreOfPlayer1, int[] scoreOfPlayer2) {
        this.scoreOfPlayer1 = scoreOfPlayer1;
        this.scoreOfPlayer2 = scoreOfPlayer2;
    }

    /**
     * Get score of player 1 int [ ].
     *
     * @return the score of player 1
     */
    public int[] getScoreOfPlayer1() {
        return scoreOfPlayer1;
    }

    /**
     * Get score of player 2 int [ ].
     *
     * @return the score of player 2
     */
    public int[] getScoreOfPlayer2() {
        return scoreOfPlayer2;
    }

    /**
     * Edit score for player 1.
     *
     * @param set      the set that the score will be edited.
     * @param newScore the new score for the given set
     * @throws IllegalArgumentException if the set have not been played.
     */
    public void editScoreForPlayer1(int set,int newScore)
            throws IllegalArgumentException{
        if(set-1>scoreOfPlayer1.length) throw new IllegalArgumentException("The defined set was not played. Enter a set between 1 and " + scoreOfPlayer1.length +".");
        scoreOfPlayer1[set-1] = newScore;
    }

    /**
     * Edit score for player 2.
     *
     * @param set      the set that the score will be edited for.
     * @param newScore the new score for the given set.
     * @throws IllegalArgumentException if the set has not been played
     */
    public void editScoreForPlayer2(int set,int newScore)
            throws IllegalArgumentException{
        if(set-1>scoreOfPlayer2.length) throw new IllegalArgumentException("The defined set was not played. Enter a set between 1 and " + scoreOfPlayer2.length +".");
        scoreOfPlayer2[set-1] = newScore;
    }
}
