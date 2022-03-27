package no.ntnu.idatx2001.oblig3.cardgame.objects;

import java.util.ArrayList;
import java.util.Random;

public class DeckOfCards {
    private ArrayList<PlayingCard> playingCards = new ArrayList<>();
    private final char[] suits = {'S','H','D','C'};


    public DeckOfCards(){
        for (char suit: suits) {
            for (int i = 1; i <= 13; i++) {
                playingCards.add(new PlayingCard(suit,i));
            }
        }
    }

    public ArrayList<PlayingCard> getPlayingCards() {
        return playingCards;
    }

    public ArrayList<PlayingCard> dealHand(int n) throws IllegalArgumentException{

        if(n < 1 || n > 52){
            throw new IllegalArgumentException("Number must be between 1 and 52");
        }

        ArrayList<PlayingCard> playerHand = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            Random random = new Random();
            int randomIndex = random.nextInt(this.playingCards.size());

            playerHand.add(this.playingCards.get(randomIndex));
            playingCards.remove(randomIndex);
        }

        return playerHand;
    }

}
