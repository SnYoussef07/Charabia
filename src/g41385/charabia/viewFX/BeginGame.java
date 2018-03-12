/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g41385.charabia.viewFX;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author g41385
 */
public class BeginGame {

    private Stage primaryStage;
    private Stage secondaryStage;
    private BorderPane rootOne;
    private TextField nameFieldOne;
    private HBox hboxNameOne;
    private HBox hboxButton;
    private Button buttonPlay;

    public BeginGame(Stage primaryStage) {
        this.primaryStage = primaryStage;
        initBeginGame();
    }

    public void initBeginGame() {
        primaryStage.setTitle("Joueur");
        nameFieldOne = new TextField();
        buttonPlay = new Button("Play");
        rootOne = new BorderPane();
        hboxNameOne = new HBox();
        hboxButton = new HBox();

        Label nameOne = new Label("Nom : ");
        hboxNameOne.getChildren().addAll(nameOne, nameFieldOne);
        hboxButton.getChildren().add(buttonPlay);
        hboxNameOne.setStyle("-fx-background-color: #FFFFFF;");
        hboxButton.setStyle("-fx-background-color: #046380;");

        
        rootOne.setCenter(hboxNameOne);
        rootOne.setBottom(hboxButton);
            
        hboxNameOne.setAlignment(Pos.CENTER);
        hboxNameOne.setPadding(new Insets(0,20,0,0));
        
        hboxButton.setAlignment(Pos.BOTTOM_CENTER);
        hboxButton.setPadding(new Insets(0,0,10,0));

        
        Scene scene = new Scene(rootOne, 300, 250);
        primaryStage.setScene(scene);
    }

    public void showBeginGamr() {
        primaryStage.show();
    }
}
