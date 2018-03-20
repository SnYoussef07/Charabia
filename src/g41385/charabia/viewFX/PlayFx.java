package g41385.charabia.viewFX;

import g41385.charabia.model.Charabia;
import g41385.charabia.model.Player;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

/**
 *
 * @author g41385
 */
public class PlayFx extends HBox {

    private Charabia charabia;
    private Player player;
    private TextField fieldWord;
    private Button proposedWord;

    public PlayFx(Charabia game, Player player) {
        charabia = game;
        this.player = player;
        /*fieldWord = new TextField();
        proposedWord = new Button("Proposer");
        this.getChildren().addAll(fieldWord, proposedWord);
        this.setAlignment(Pos.BOTTOM_CENTER);
        this.setPadding(new Insets(20, 20, 20, 20));*/
        myPlay();

        
        /*proposedWord.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                if (charabia.isPlay(fieldWord.getText())) {
                    charabia.play(player, fieldWord.getText());
                    //fieldWord.setEditable(false);
                    //proposedWord.setDisable(true);
                    fieldWord.setStyle("-fx-background-color: rgba(11, 198, 68, .8);");
                } else {
                    fieldWord.setStyle("-fx-background-color: rgba(243, 0, 0, .8);");
                }
            }
        });*/

    }

    public void myPlay() {
        this.getChildren().clear();
        fieldWord = new TextField();
        fieldWord.setPromptText(charabia.findBestWord());
        
        proposedWord = new Button("Proposer");
        this.getChildren().addAll(fieldWord, proposedWord);
        this.setAlignment(Pos.BOTTOM_CENTER);
        this.setPadding(new Insets(20, 20, 20, 20));
        
        proposedWord.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                if (charabia.isPlay(fieldWord.getText())) {
                    charabia.play(player, fieldWord.getText());
                    fieldWord.setEditable(false);
                    proposedWord.setDisable(true);
                    fieldWord.setStyle("-fx-background-color: rgba(11, 198, 68, .8);");
                } else {
                    fieldWord.setStyle("-fx-background-color: rgba(243, 0, 0, .8);");
                }
            }
        });

    }

    public void refreshPlay() {
        myPlay();
    }
}
