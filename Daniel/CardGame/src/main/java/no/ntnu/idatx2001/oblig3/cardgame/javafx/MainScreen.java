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

        Button dealHandButton = new Button("Deal hand");
        Button checkHandButton = new Button("Check hand");

        Label sumOfFacesLabel = new Label("Sum of the faces:");
        Label cardsOfHeartsLabel = new Label("Cards of hearts:");
        Label flushLabel = new Label("Flush:");
        Label queenOfSpadesLabel = new Label("Queen of spades:");

        Label sumOfFacesShow = new Label();
        Label cardsOfHeartsShow = new Label();
        Label flushShow = new Label();
        Label queenOfSpadesShow = new Label();

        Label defaultText = new Label("Press the deal hand button for cards");

        VBox rightSideBox = new VBox(dealHandButton,checkHandButton);
        HBox cardDisplay = new HBox(defaultText);

        HBox sumOfFacesBox = new HBox(sumOfFacesLabel,sumOfFacesShow);
        HBox cardsOfHeartsBox = new HBox(cardsOfHeartsLabel,cardsOfHeartsShow);
        HBox flushBox = new HBox(flushLabel,flushShow);
        HBox queenOfSpadesBox = new HBox(queenOfSpadesLabel,queenOfSpadesShow);



        GridPane layout = new GridPane();
        layout.add(cardDisplay,0,0,3,3);
        layout.add(rightSideBox,4,0,1,3);
        layout.add(sumOfFacesBox,0,4,1,1);
        layout.add(cardsOfHeartsBox,1,4,1,1);
        layout.add(flushBox,0,5,1,1);
        layout.add(queenOfSpadesBox,1,5,1,1);


        dealHandButton.setOnAction(actionEvent -> {
            dealHand(cardDisplay.getChildren());
        });

        checkHandButton.setOnAction(actionEvent -> {
            checkHand(sumOfFacesShow, cardsOfHeartsShow, flushShow, queenOfSpadesShow);
        });



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


        Scene scene = new Scene(layout,WIDTH,HEIGHT);
        scene.getStylesheets().add(getClass().getResource("MainScreen.css").toExternalForm());
        stage.setTitle("Card Game");
        stage.setScene(scene);
        stage.show();
    }



    private void dealHand(ObservableList<Node> cardDisplay){
        while(!cardDisplay.isEmpty()){
            cardDisplay.remove(0);
        }

        CardsInHand cardsInHand = new CardsInHand(new DeckOfCards(),5);
        playingCards = cardsInHand.getCardsInHand();
        ArrayList<Image> cardImages = new CardImageController(cardsInHand.getCardsInHand()).getImages();


        for (Image image: cardImages) {
            ImageView imageView = new ImageView(image);
            imageView.setFitWidth(125);
            imageView.setFitHeight(181.5);
            imageView.setPreserveRatio(true);

            cardDisplay.add(imageView);
        }
    }

    private void checkHand(Label sumOfFacesShow, Label cardsOfHeartsShow, Label flushShow, Label queenOfSpadesShow){

        int sumOfFaces = 0;
        for (PlayingCard card: this.playingCards) {
            sumOfFaces += card.getFace();
        }
        sumOfFacesShow.setText(String.valueOf(sumOfFaces));


        String cardsOfHeartsText = "";
        for (PlayingCard card: this.playingCards) {
            if(card.getSuit() == 'H'){
                cardsOfHeartsText += card.getAsString() + " ";
            }
        }
        if(cardsOfHeartsText.isBlank()){
            cardsOfHeartsShow.setText("No Hearts");
        }else{
            cardsOfHeartsShow.setText(cardsOfHeartsText);
        }


        CardsInHand cardsInHand = new CardsInHand(this.playingCards);
        if(cardsInHand.isFlush()){
            flushShow.setText("YES");
        }else{
            flushShow.setText("NO");
        }


        boolean queenOfSpadesExists = false;
        for (PlayingCard card: this.playingCards) {
            if(card.getAsString().equals("S12")){
                queenOfSpadesExists = true;
            }
        }
        if(queenOfSpadesExists){
            queenOfSpadesShow.setText("YES");
        }else{
            queenOfSpadesShow.setText("NO");
        }

    }



    public static void main(String[] args) {
        launch();
    }
}