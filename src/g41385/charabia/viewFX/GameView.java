package g41385.charabia.viewFX;

import g41385.charabia.model.Charabia;
import g41385.charabia.model.CharabiaGame;
import g41385.charabia.model.State;
import g41385.charabia.model.Tile;
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
public class GameView extends BorderPane {

    private Charabia charabia;
    private HBox hboxPlayerOne;
    private HBox hboxPlayerTwo;
    private VBox vboxPlayers;
    private HBox hboxTable;
    private TextField fieldWord;
    private Button proposedWord;
    private HBox hboxPlay;

    public GameView(Charabia charabia) {
        this.charabia = charabia;
        hboxPlayerOne = new HBox();
        hboxPlayerTwo = new HBox();
        vboxPlayers = new VBox();
        hboxTable = new HBox();
        fieldWord = new TextField();
        proposedWord = new Button(">");
        hboxPlay = new HBox();

        initPlayer();

        initTable();

        initPLay();
    }

    public void initPlayer() {
        vboxPlayers.getChildren().clear();
        Label nameOne = new Label("name = " + charabia.getPlayers().get(0).getName() + " || ");
        Label nameTwo = new Label("name = " + charabia.getPlayers().get(1).getName() + " || ");
        Label scoreOne = new Label("Score = " + charabia.getPlayers().get(0).getScore());
        Label scoreTwo = new Label("Score = " + charabia.getPlayers().get(1).getScore());

        hboxPlayerOne.getChildren().addAll(nameOne, scoreOne);
        hboxPlayerTwo.getChildren().addAll(nameTwo, scoreTwo);
        vboxPlayers.getChildren().addAll(hboxPlayerOne, hboxPlayerTwo);
        this.setTop(vboxPlayers);
        hboxPlayerOne.setAlignment(Pos.TOP_CENTER);
        hboxPlayerTwo.setAlignment(Pos.TOP_CENTER);
    }

    public void initTable() {
        hboxTable.getChildren().clear();
        List<VBox> hboxTiles = new ArrayList();

        String pathCar = null;
        String pathNum = null;

        for (Tile tt : charabia.getListTile()) {
            pathCar = "sourcCharabia/" + tt.getLetter() + ".png";
            pathNum = "sourcCharabia/" + tt.getPoints() + ".png";

            hboxTiles.add(new VBox(new ImageView(new Image(new File(pathCar).toURI().toString())),
                    new ImageView(new Image(new File(pathNum).toURI().toString()))));
        }

        for (VBox hh : hboxTiles) {
            hh.setAlignment(Pos.CENTER);
            hh.setSpacing(-7);
        }

        hboxTable.getChildren().addAll(hboxTiles);
        this.setCenter(hboxTable);
        hboxTable.setAlignment(Pos.CENTER);
        hboxTable.setSpacing(5);
    }

    public void initPLay() {
        if (charabia.isRoundOver()) {
            charabia.nextRound();
            roundOver();
            initPlayer();
            initTable();
        }
        fieldWord.setPromptText(charabia.findBestWord());
        hboxPlay.getChildren().addAll(fieldWord, proposedWord);
        hboxPlay.setAlignment(Pos.BOTTOM_CENTER);
        this.setBottom(hboxPlay);
        hboxPlay.setPadding(new Insets(20, 20, 20, 20));

        /*proposedWord.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                if (charabia.isPlay(fieldWord.getText())) {
                    charabia.play(charabia.getCurrentPlayer(), fieldWord.getText());
                    fieldWord.setEditable(false);
                    proposedWord.setDisable(true);
                    fieldWord.setStyle("-fx-background-color: rgba(11, 198, 68, .8);");

                } else {
                    fieldWord.setStyle("-fx-background-color: rgba(243, 0, 0, .8);");
                }

            }
        });*/

    }

    public void roundOver() {
        this.getChildren().clear();
    }
}
