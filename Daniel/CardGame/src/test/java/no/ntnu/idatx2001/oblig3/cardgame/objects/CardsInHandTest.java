package no.ntnu.idatx2001.oblig3.cardgame.objects;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CardsInHandTest {

    CardsInHand cardsInHand;

    @BeforeEach
    void setUp() {
        ArrayList<PlayingCard> playingCards = new ArrayList<>();
        playingCards.add(new PlayingCard('H',3));
        playingCards.add(new PlayingCard('H',6));
        playingCards.add(new PlayingCard('D',12));
        playingCards.add(new PlayingCard('H',11));
        playingCards.add(new PlayingCard('D',2));

        cardsInHand = new CardsInHand(playingCards);
    }

    @Test
    void isFlush() {
        Assertions.assertTrue(cardsInHand.isFlush());
    }
}