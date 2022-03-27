package no.ntnu.idatx2001.oblig3.cardgame.objects;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the cards that the player is holding in their hands.
 * After being dealt cards from the deck, the receives the specified
 * amount of cards in their hands
 *
 * @author Daniel
 * @version 2020-03-27
 */
public class CardsInHand {
    private ArrayList<PlayingCard> cardsInHand;

    /**
     * Constructor for creating cards in the player's hand.
     * The constructor calls the dealHand method from the DeckOfCards class
     * and deals the specified amount of cards.
     *
     * @param deckOfCards deck of cards that the player draws from.
     * @param n amount of cards the player receives.
     */
    public CardsInHand(DeckOfCards deckOfCards,int n){
        this.cardsInHand = deckOfCards.dealHand(n);
    }

    /**
     * Constructor for creating cards in the player's hand.
     * The list specified in the parameters is inputted into
     * the class' list of cards.
     *
     * @param cardsInHand a list of cards that the player receives
     */
    public CardsInHand(ArrayList<PlayingCard> cardsInHand){
        this.cardsInHand = cardsInHand;
    }

    /**
     * Returns the cards the player is holding
     *
     * @return array list of playing cards that the player is holding.
     */
    public ArrayList<PlayingCard> getCardsInHand() {
        return cardsInHand;
    }

    /**
     * Checks if the current cards that the player is holding
     * is a flush. A flush occurs when the color of all the cards
     * are the same.
     *
     * @return true if you have a flush, false if you dont.
     */
    public boolean isFlush(){
        int reds = 0;
        int blacks = 0;

        for (PlayingCard card: this.cardsInHand) {              // Counts the number of reds and blacks in the player's hand based on the suit
            if(card.getSuit() == 'D' || card.getSuit() == 'H'){
                reds++;
            }else{
                blacks++;
            }
        }

        if(reds == this.cardsInHand.size() || blacks == this.cardsInHand.size()){
            return true;
        }else{
            return false;
        }

    }

    /**
     * Returns the sum of the faces on the
     * cards of the player
     *
     * @return sum of the faces
     */
    public int sumOfFaces(){
        int sumOfFaces = 0;
        for (PlayingCard card: this.cardsInHand) {
            sumOfFaces += card.getFace();
        }
        return sumOfFaces;
    }

    /**
     * Returns an array list of all the playing cards
     * containing the suit hearts
     *
     * @return an array list of all the playing cards with the suit hearts
     */
    public ArrayList<PlayingCard> allHeartCards(){
        ArrayList<PlayingCard> heartCards = new ArrayList<>();

        for (PlayingCard card: this.cardsInHand) {
            if(card.getSuit() == 'H'){
                heartCards.add(card);
            }
        }

        return heartCards;
    }

    /**
     * Checks if there is a queen of spades in
     * the player's hand
     *
     * @return true if there is a queen of spades in the player's hand, false if not
     */
    public boolean queenOfSpadesExistsInHand(){

        boolean queenOfSpadesExists = false;
        for (PlayingCard card: this.cardsInHand) {
            if(card.getAsString().equals("S12")){
                queenOfSpadesExists = true;
            }
        }
        return queenOfSpadesExists;
    }

}
