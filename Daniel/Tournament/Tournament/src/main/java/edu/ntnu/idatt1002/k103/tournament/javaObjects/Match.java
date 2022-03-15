package edu.ntnu.idatt1002.k103.tournament.javaObjects;

/**
 * The type Match.
 */
public class Match {
    private final Person player1;
    private final Person player2;
    private  Score score;
    //TODO:
    //Accessor and mutator methods for winner
    //

    /**
     * Instantiates a new Match.
     *
     * @param player1 the player 1
     * @param player2 the player 2
     */
    public Match(Person player1, Person player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    /**
     * Sets score.
     *
     * @param score the score of the match
     */
    public void setScore(Score score) {
        this.score = score;
    }

    /**
     * Get winner person.
     *
     * @return the winner of the match.
     */
    public Person getWinner(){
        int sumOfSets =0;
        for(int i =0; i <score.getScoreOfPlayer1().length;i++){
            if(score.getScoreOfPlayer1()[i]>score.getScoreOfPlayer2()[i])  sumOfSets++;
            else sumOfSets--;
        }
        if(sumOfSets>0) return player1;
        else if(sumOfSets<0) return player2;
        return null;
    }

    /**
     * sets the new rating of the player after the match has been played. the winner gets an additional 10 points added to their rating.
     * the loser's rating is reduced by 10 points.
     * @param winner of the match.
     */
    private void AddRating(Person winner){
        if(winner.equals(player1)){
            player1.setRating(player1.getRating()+10);
            player2.setRating(player2.getRating()-10);
        } else{
            player1.setRating(player1.getRating()-10);
            player2.setRating(player2.getRating()+10);
        }
    }
}
