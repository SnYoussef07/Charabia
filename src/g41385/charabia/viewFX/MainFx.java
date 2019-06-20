/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g41385.charabia.viewFX;

import g41385.charabia.model.CharabiaGame;
import g41385.charabia.model.State;
import java.io.File;
import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.stage.Stage;

/**
 *
 * @author g41385
 */
public class MainFx extends Application {

    private CharabiaGame charabia;
    Scene sceneGameOne;
    Scene sceneGameTwo;

    public MainFx() throws IOException {
        charabia = new CharabiaGame();
    }

    @Override
    public void start(Stage primaryStage) {
        Stage secondaryStage = new Stage();
        primaryStage.setTitle("Joueur 1");
        secondaryStage.setTitle("Joueur 2");

        MenuGame menuGameOne = new MenuGame();
        MenuGame menuGameTwo = new MenuGame();
        backgroundMenuGame(menuGameOne, menuGameTwo);

        WaitOtherPlayer waitOne = new WaitOtherPlayer();
        WaitOtherPlayer waitTwo = new WaitOtherPlayer();

        Scene sceneMenuOne = new Scene(menuGameOne, 600, 400);
        Scene sceneMenuTwo = new Scene(menuGameTwo, 600, 400);
        primaryStage.setResizable(false);
        secondaryStage.setResizable(false);

        primaryStage.setScene(sceneMenuOne);
        secondaryStage.setScene(sceneMenuTwo);
        primaryStage.show();
        secondaryStage.show();

        gameAction(menuGameOne, sceneMenuOne, waitOne, primaryStage, 
                secondaryStage, menuGameTwo, sceneMenuTwo, waitTwo);

    }

    private void gameAction(MenuGame menuGameOne, Scene sceneMenuOne, 
            WaitOtherPlayer waitOne, Stage primaryStage, Stage secondaryStage, 
            MenuGame menuGameTwo, Scene sceneMenuTwo, WaitOtherPlayer waitTwo) {
        
        menuGameOne.getButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                charabia.joinGame(menuGameOne.getName());
                if (charabia.getState().equals(State.CONFIGURE)) {
                    sceneMenuOne.setRoot(waitOne);
                } else if (charabia.getState().equals(State.STARTED)) {
                    GameView gameOne = new GameView(charabia, charabia.
                            getPlayers().get(0));
                    sceneGameOne = new Scene(gameOne, 1100, 700);
                    GameView gameTwo = new GameView(charabia, charabia.
                            getPlayers().get(1));
                    sceneGameTwo = new Scene(gameTwo, 1100, 700);

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
                    GameView gameOne = new GameView(charabia, charabia.
                            getPlayers().get(0));
                    sceneGameOne = new Scene(gameOne, 1100, 700);
                    GameView gameTwo = new GameView(charabia, charabia.
                            getPlayers().get(1));
                    sceneGameTwo = new Scene(gameTwo, 1100, 700);

                    primaryStage.setScene(sceneGameOne);
                    secondaryStage.setScene(sceneGameTwo);
                }
            }
        });
    }

    public void backgroundMenuGame(MenuGame menuGameOne, MenuGame menuGameTwo) {
        Image imageOne = new Image(new File("sourcCharabia/fond1.png")
                .toURI().toString());
        Image imageTwo = new Image(new File("sourcCharabia/fond2.png")
                .toURI().toString());
        BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, 
                BackgroundSize.AUTO, false, false, true, false);
        menuGameOne.setBackground(new Background(new BackgroundImage(imageOne,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                bSize)));
        menuGameTwo.setBackground(new Background(new BackgroundImage(imageTwo,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                bSize)));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
