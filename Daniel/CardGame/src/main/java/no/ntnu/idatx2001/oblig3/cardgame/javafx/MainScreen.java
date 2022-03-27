package no.ntnu.idatx2001.oblig3.cardgame.javafx;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import no.ntnu.idatx2001.oblig3.cardgame.javafx.images.CardImageController;
import no.ntnu.idatx2001.oblig3.cardgame.objects.CardsInHand;
import no.ntnu.idatx2001.oblig3.cardgame.objects.DeckOfCards;
import no.ntnu.idatx2001.oblig3.cardgame.objects.PlayingCard;

import java.io.IOException;
import java.util.ArrayList;

public class MainScreen extends Application {

    private double WIDTH = 1000;
    private double HEIGHT = (WIDTH/16) * 9;
    private ArrayList<PlayingCard> playingCards;

    @Override
    public void start(Stage stage) throws IOException {

        //Defining the different buttons
        Button dealHandButton = new Button("Deal hand");
        Button checkHandButton = new Button("Check hand");

        //Defining the different labels
        Label sumOfFacesLabel = new Label("Sum of the faces:");
        Label cardsOfHeartsLabel = new Label("Cards of hearts:");
        Label flushLabel = new Label("Flush:");
        Label queenOfSpadesLabel = new Label("Queen of spades:");

        Label sumOfFacesShow = new Label();
        Label cardsOfHeartsShow = new Label();
        Label flushShow = new Label();
        Label queenOfSpadesShow = new Label();

        Label defaultText = new Label("Press the deal hand button for cards");

        //Defining the different boxes (VBox and HBox)
        VBox rightSideBox = new VBox(dealHandButton,checkHandButton);
        HBox cardDisplay = new HBox(defaultText);

        HBox sumOfFacesBox = new HBox(sumOfFacesLabel,sumOfFacesShow);
        HBox cardsOfHeartsBox = new HBox(cardsOfHeartsLabel,cardsOfHeartsShow);
        HBox flushBox = new HBox(flushLabel,flushShow);
        HBox queenOfSpadesBox = new HBox(queenOfSpadesLabel,queenOfSpadesShow);


        //Grid laying the different nodes
        GridPane layout = new GridPane();
        layout.add(cardDisplay,0,0,3,3);
        layout.add(rightSideBox,4,0,1,3);
        layout.add(sumOfFacesBox,0,4,1,1);
        layout.add(cardsOfHeartsBox,1,4,1,1);
        layout.add(flushBox,0,5,1,1);
        layout.add(queenOfSpadesBox,1,5,1,1);


        //Action event for the deal hand button
        dealHandButton.setOnAction(actionEvent -> {
            dealHand(cardDisplay.getChildren());
        });

        //Action event for the check hand button
        checkHandButton.setOnAction(actionEvent -> {
            checkHand(sumOfFacesShow, cardsOfHeartsShow, flushShow, queenOfSpadesShow);
        });

        //Adding css ids and classes to different nodes
        layout.setId("layout");
        cardDisplay.setId("cardDisplay");
        rightSideBox.setId("rightSideBox");

        sumOfFacesBox.getStyleClass().add("info");
        cardsOfHeartsBox.getStyleClass().add("info");
        flushBox.getStyleClass().add("info");
        queenOfSpadesBox.getStyleClass().add("info");

        sumOfFacesShow.getStyleClass().add("infoShow");
        cardsOfHeartsShow.getStyleClass().add("infoShow");
        flushShow.getStyleClass().add("infoShow");
        queenOfSpadesShow.getStyleClass().add("infoShow");


        //Creating the scene and setting the stage, adding the css file from the resources file
        Scene scene = new Scene(layout,WIDTH,HEIGHT);
        scene.getStylesheets().add(getClass().getResource("MainScreen.css").toExternalForm());
        stage.setTitle("Card Game");
        stage.setScene(scene);
        stage.show();
    }


    /**
     * Method for dealing cards to the player. The player
     * receives 5 cards and displays the different cards on
     * screen for the player to see.
     *
     * @param cardDisplay ObservableList where the cards will be displayed
     */
    private void dealHand(ObservableList<Node> cardDisplay){
        //Empties the display of cards before new ones can be displayed
        while(!cardDisplay.isEmpty()){
            cardDisplay.remove(0);
        }

        CardsInHand cardsInHand = new CardsInHand(new DeckOfCards(),5);
        playingCards = cardsInHand.getCardsInHand();
        ArrayList<Image> cardImages = new CardImageController(cardsInHand.getCardsInHand()).getImages();


        for (Image image: cardImages) {                 //Adds the images to the ObservableList for display to the player
            ImageView imageView = new ImageView(image);
            imageView.setFitWidth(125);
            imageView.setFitHeight(181.5);
            imageView.setPreserveRatio(true);

            cardDisplay.add(imageView);
        }
    }

    /**
     * Checks the current hand for miscellaneous information.
     * Calculates the sum of the faces, shows which cards that
     * contain the heart suit, if the player has a flush or if
     * the player has specifically a queen of spades. Replaces the
     * text of the different labels with their respective information
     *
     * @param sumOfFacesShow Label which will contain information about the sum of faces
     * @param cardsOfHeartsShow Label which will contain information about which cards have the suit hearts
     * @param flushShow Label which will contain information about if the player has a flush or not
     * @param queenOfSpadesShow Label which will contain information about if the player has a queen of spades or not
     */
    private void checkHand(Label sumOfFacesShow, Label cardsOfHeartsShow, Label flushShow, Label queenOfSpadesShow){
        CardsInHand cardsInHand = new CardsInHand(this.playingCards);


        sumOfFacesShow.setText(String.valueOf(cardsInHand.sumOfFaces())); //Calculates the sum of the cards


        String cardsOfHeartsText = "";                                   //Prints out all the cards with heart suit
        for (PlayingCard p: cardsInHand.allHeartCards()) {
            cardsOfHeartsText += p.getAsString() + " ";
        }


        if(cardsOfHeartsText.isBlank()){
            cardsOfHeartsShow.setText("No Hearts");
        }else{
            cardsOfHeartsShow.setText(cardsOfHeartsText);
        }


        if(cardsInHand.isFlush()){                                     //Checks if there is a flush
            flushShow.setText("YES");
        }else{
            flushShow.setText("NO");
        }

        if(cardsInHand.queenOfSpadesExistsInHand()){                  //Checks if there is a queen of spades
            queenOfSpadesShow.setText("YES");
        }else{
            queenOfSpadesShow.setText("NO");
        }

    }



    public static void main(String[] args) {
        launch(args);
    }
}