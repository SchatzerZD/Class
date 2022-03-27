package no.ntnu.idatx2001.oblig3.cardgame.objects;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class CardsInHandTest {

    CardsInHand cardsInHandFlush;
    CardsInHand cardsInHandNotFlush;

    @BeforeEach
    void setUp() {
        ArrayList<PlayingCard> playingCardsFlush = new ArrayList<>();
        playingCardsFlush.add(new PlayingCard('H',3));
        playingCardsFlush.add(new PlayingCard('H',6));
        playingCardsFlush.add(new PlayingCard('D',12));
        playingCardsFlush.add(new PlayingCard('H',11));
        playingCardsFlush.add(new PlayingCard('D',2));

        cardsInHandFlush = new CardsInHand(playingCardsFlush);

        ArrayList<PlayingCard> playingCardsNotFlush = new ArrayList<>();
        playingCardsNotFlush.add(new PlayingCard('S',4));
        playingCardsNotFlush.add(new PlayingCard('H',12));
        playingCardsNotFlush.add(new PlayingCard('D',2));
        playingCardsNotFlush.add(new PlayingCard('C',2));

        cardsInHandNotFlush = new CardsInHand(playingCardsNotFlush);
    }

    @Test
    void isFlush() {
        Assertions.assertTrue(cardsInHandFlush.isFlush());
        Assertions.assertFalse(cardsInHandNotFlush.isFlush());
    }

    @Test
    void sumOfFaces() {
        Assertions.assertEquals(34,cardsInHandFlush.sumOfFaces());
        Assertions.assertEquals(20,cardsInHandNotFlush.sumOfFaces());
    }

    @Test
    void allHeartCards() {
        Assertions.assertEquals(3,cardsInHandFlush.allHeartCards().size());
    }

    @Test
    void queenOfSpadesExistsInHand() {
        Assertions.assertFalse(cardsInHandFlush.queenOfSpadesExistsInHand());
    }
}