/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g41385.charabia.viewFX;

import g41385.charabia.model.Charabia;
import g41385.charabia.model.CharabiaGame;
import g41385.charabia.model.State;
import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author g41385
 */
public class NewFXMain extends Application {

    private Charabia charabia;
    Scene sceneGameOne;
    Scene sceneGameTwo;

    public NewFXMain() throws IOException {
        charabia = new CharabiaGame();
    }

    @Override
    public void start(Stage primaryStage) {
        Stage secondaryStage = new Stage();
        primaryStage.setTitle("Joueur 1");
        secondaryStage.setTitle("Joueur 2");

        MenuGame menuGameOne = new MenuGame();
        MenuGame menuGameTwo = new MenuGame();

        WaitOtherPlayer waitOne = new WaitOtherPlayer();
        WaitOtherPlayer waitTwo = new WaitOtherPlayer();


        Scene sceneMenuOne = new Scene(menuGameOne, 600, 400);
        Scene sceneMenuTwo = new Scene(menuGameTwo, 600, 400);


        primaryStage.setScene(sceneMenuOne);
        secondaryStage.setScene(sceneMenuTwo);
        primaryStage.show();
        secondaryStage.show();

        menuGameOne.getButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                charabia.joinGame(menuGameOne.getName());

                if (charabia.getState().equals(State.CONFIGURE)) {
                    sceneMenuOne.setRoot(waitOne);
                } else if (charabia.getState().equals(State.STARTED)) {
                    GameView gameOne = new GameView(charabia);
                    sceneGameOne = new Scene(gameOne, 1280, 900);
                    GameView gameTwo = new GameView(charabia);
                    sceneGameTwo = new Scene(gameTwo, 1280, 900);

                    primaryStage.setScene(sceneGameOne);
                    secondaryStage.setScene(sceneGameTwo);
                }
            }
        });

        menuGameTwo.getButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                charabia.joinGame(menuGameTwo.getName());

                if (charabia.getState().equals(State.CONFIGURE)) {
                    sceneMenuTwo.setRoot(waitTwo);
                } else if (charabia.getState().equals(State.STARTED)) {
                    GameView gameOne = new GameView(charabia);
                    sceneGameOne = new Scene(gameOne, 1280,900);
                    GameView gameTwo = new GameView(charabia);
                    sceneGameTwo = new Scene(gameTwo, 1280,900);
                    
                    primaryStage.setScene(sceneGameOne);
                    secondaryStage.setScene(sceneGameTwo);
                }
            }
        });

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}