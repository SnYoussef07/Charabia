package g41385.charabia.viewFX;

import g41385.charabia.model.Charabia;
import g41385.charabia.model.CharabiaGame;
import g41385.charabia.model.Player;
import g41385.charabia.model.State;
import g41385.charabia.model.Tile;
import g41385.charabia.observer.Observer;
import java.awt.Color;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author snsmaug
 */
public class GameView extends BorderPane implements Observer {

    private CharabiaGame charabia;

    private TableFx tableFx;
    private PlayerFx playerFx;

    private TextField fieldWord;
    private Button proposedWord;
    private HBox hboxPlay;
    private Player playerTest;

    public GameView(CharabiaGame charabia, Player player) {
        this.charabia = charabia;

        tableFx = new TableFx(charabia);
        this.setCenter(tableFx);
        playerFx = new PlayerFx(charabia);
        this.setTop(playerFx);

        fieldWord = new TextField();
        proposedWord = new Button(">");
        hboxPlay = new HBox();
        playerTest = player;
        this.charabia.registerObserver(this);

        initPLay();
    }

    public void initPLay() {

        fieldWord.setPromptText(charabia.findBestWord());
        hboxPlay.getChildren().addAll(fieldWord, proposedWord);
        hboxPlay.setAlignment(Pos.BOTTOM_CENTER);
        this.setBottom(hboxPlay);
        hboxPlay.setPadding(new Insets(20, 20, 20, 20));

        proposedWord.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                if (charabia.isPlay(fieldWord.getText())) {
                    charabia.play(playerTest, fieldWord.getText());
                    fieldWord.setEditable(false);
                    proposedWord.setDisable(true);
                    fieldWord.setStyle("-fx-background-color: rgba(11, 198, 68, .8);");
                } else {
                    fieldWord.setStyle("-fx-background-color: rgba(243, 0, 0, .8);");
                }
            }
        });

    }

    public void roundOver() {
        this.getChildren().clear();
    }

    @Override
    public void update() {
        /*if(charabia.isGameOver()){
            
        }*/
        /*if (charabia.isRoundOver()) {
            charabia.nextRound();
            fieldWord.setEditable(true);
            proposedWord.setDisable(false);
            tableFx.refreshTable();
            playerFx.refreshPlayers();
        }*/
        /*fieldWord.setEditable(true);
        proposedWord.setDisable(false);
        charabia.nextRound();
        tableFx.refreshTable();
        playerFx.refreshPlayers();*/
    }
}
