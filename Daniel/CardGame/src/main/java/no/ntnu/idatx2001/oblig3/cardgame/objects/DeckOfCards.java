package no.ntnu.idatx2001.oblig3.cardgame.objects;

import java.util.ArrayList;
import java.util.Random;

/**
 * Represesnts a deck of cards. A deck of cards contains a total
 * of 52 different playing cards, with 4 different suits, 13 different
 * numbers and 2 different colors.
 *
 * @author Daniel
 * @version 2020-03-27
 */

public class DeckOfCards {
    private ArrayList<PlayingCard> playingCards = new ArrayList<>(); // An arraylist which is going to contain the 52 cards. I used an arraylist because
                                                                    // it should be possible to remove cards from the deck when dealing to the hand.
    private final char[] suits = {'S','H','D','C'}; //S = spades, H = hearts, D = diamonds, C = clubs

    /**
     * Constructor for creating a deck of cards, containing all
     * possible 52 cards.
     */
    public DeckOfCards(){
        for (char suit: suits) {
            for (int i = 1; i <= 13; i++) {
                playingCards.add(new PlayingCard(suit,i));
            }
        }
    }

    /**
     * Returns an arraylist of the PlayingCard class, with 52 different cards
     *
     * @return array of playing cards
     */
    public ArrayList<PlayingCard> getPlayingCards() {
        return playingCards;
    }

    /**
     * Deals cards from the deck to the player's hand, and removes the cards
     * from the deck. The number of cards the player receives is specified in the
     * parameters
     *
     * @param n the number of cards that is going to be dealt
     * @return an array list of the PlayingCard class
     * @throws IllegalArgumentException if the number in the parameters exceeds the size of the deck
     */
    public ArrayList<PlayingCard> dealHand(int n) throws IllegalArgumentException{

        if(n < 1 || n > this.playingCards.size()){
            throw new IllegalArgumentException("Number must be between 1 and the size of the deck");
        }

        ArrayList<PlayingCard> playerHand = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            Random random = new Random();
            int randomIndex = random.nextInt(this.playingCards.size()); //Creates a random integer with the size of the deck as upper bounds.

            playerHand.add(this.playingCards.get(randomIndex)); //Adds the card to the player's hand
            playingCards.remove(randomIndex); //Removes the same card from the deck
        }

        return playerHand;
    }

}
