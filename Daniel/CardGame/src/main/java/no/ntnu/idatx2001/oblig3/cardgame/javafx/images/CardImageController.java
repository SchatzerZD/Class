package no.ntnu.idatx2001.oblig3.cardgame.javafx.images;

import javafx.scene.image.Image;
import no.ntnu.idatx2001.oblig3.cardgame.objects.PlayingCard;

import java.util.ArrayList;

/**
 * A controller class for handling the images in the
 * resources folder.
 *
 * @author ntnu
 * @version 2020-01-10
 */
public class CardImageController {
    private ArrayList<PlayingCard> playingCards;
    private PlayingCard playingCard;

    /**
     * Constructor for creating the controller. Input
     * an array list of playing cards to use for getting
     * the respective images from the resources folder.
     *
     * @param playingCards array list of playing cards
     */
    public CardImageController(ArrayList<PlayingCard> playingCards){
        this.playingCards = playingCards;
        this.playingCard = null;
    }

    /**
     * Constructor for creating the controller. Input
     * a singular playing card to use for getting
     * the respective image from the resources folder.
     *
     * @param playingCard a playing card
     */
    public CardImageController(PlayingCard playingCard){
        this.playingCard = playingCard;
        this.playingCards = null;
    }

    /**
     * Returns an array list of images from this class'
     * list of cards
     *
     * @return array list of images depicting cards
     */
    public ArrayList<Image> getImages(){
        ArrayList<Image> imageArrayList = new ArrayList<>();

        for (PlayingCard p: playingCards) {         //Finds all the cards with their respective images
            imageArrayList.add(new Image(getClass().getResource(p.getAsString() + ".png").toExternalForm()));
        }
        return  imageArrayList;
    }

    /**
     * Returns a singular image of the playing card
     * in this class
     *
     * @return an image of a card
     */
    public Image getImage(){
        return new Image(getClass().getResource(this.playingCard.getAsString() + "png").toExternalForm());
    }
}
