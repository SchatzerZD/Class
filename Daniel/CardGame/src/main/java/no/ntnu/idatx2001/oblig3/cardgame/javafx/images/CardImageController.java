package no.ntnu.idatx2001.oblig3.cardgame.javafx.images;

import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import no.ntnu.idatx2001.oblig3.cardgame.objects.PlayingCard;

import java.util.ArrayList;

public class CardImageController {
    private ArrayList<PlayingCard> playingCards;
    private PlayingCard playingCard;

    public CardImageController(ArrayList<PlayingCard> playingCards){
        this.playingCards = playingCards;
        this.playingCard = null;
    }

    public CardImageController(PlayingCard playingCard){
        this.playingCard = playingCard;
        this.playingCards = null;
    }

    public ArrayList<Image> getImages(){
        ArrayList<Image> imageArrayList = new ArrayList<>();

        for (PlayingCard p: playingCards) {
            imageArrayList.add(new Image(getClass().getResource(p.getAsString() + ".png").toExternalForm()));
        }
        return  imageArrayList;
    }

    public Image getImage(){
        return new Image(getClass().getResource(this.playingCard.getAsString() + "png").toExternalForm());
    }
}
