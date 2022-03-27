package no.ntnu.idatx2001.oblig3.cardgame.objects;

import java.util.ArrayList;
import java.util.Arrays;

public class CardsInHand {
    private ArrayList<PlayingCard> cardsInHand;


    public CardsInHand(DeckOfCards deckOfCards,int n){
        this.cardsInHand = deckOfCards.dealHand(n);
    }

    public CardsInHand(ArrayList<PlayingCard> cardsInHand){
        this.cardsInHand = cardsInHand;
    }

    public ArrayList<PlayingCard> getCardsInHand() {
        return cardsInHand;
    }

    public boolean isFlush(){
        if(this.cardsInHand.size() < 5){
            return false;
        }
        int reds = 0;
        int blacks = 0;

        for (PlayingCard card: this.cardsInHand) {
            if(card.getSuit() == 'D' || card.getSuit() == 'H'){
                reds++;
            }else{
                blacks++;
            }
        }

        if(reds >= 5 || blacks >= 5){
            return true;
        }else{
            return false;
        }

    }
}
