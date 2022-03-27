package no.ntnu.idatx2001.oblig3.cardgame.objects;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlayingCardTest {
    PlayingCard playingCard;

    @BeforeEach
    void setUp() {
        playingCard = new PlayingCard('S',4);
    }

    @Test
    void getAsString() {
        Assertions.assertEquals("S4",playingCard.getAsString());
    }

    @Test
    void getSuit() {
        Assertions.assertEquals('S',playingCard.getSuit());
    }

    @Test
    void getFace() {
        Assertions.assertEquals(4,playingCard.getFace());
    }
}