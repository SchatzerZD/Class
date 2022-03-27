package no.ntnu.idatx2001.oblig3.cardgame.objects;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class DeckOfCardsTest {
    DeckOfCards deckOfCards;

    @BeforeEach
    void setUp() {
        deckOfCards = new DeckOfCards();
    }

    @Test
    void getPlayingCards() {
        Assertions.assertEquals("S11",deckOfCards.getPlayingCards().get(10).toString());
        Assertions.assertEquals("D2",deckOfCards.getPlayingCards().get(27).toString());
    }

    @Test
    void dealHand() {
        ArrayList<PlayingCard> cardsInHand = deckOfCards.dealHand(3);

        Assertions.assertEquals(3,cardsInHand.size());
        Assertions.assertEquals(49,deckOfCards.getPlayingCards().size());

        Assertions.assertFalse(deckOfCards.getPlayingCards().contains(cardsInHand));
    }
}