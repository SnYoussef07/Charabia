package g41385.charabia.viewFX;

import g41385.charabia.model.Charabia;
import g41385.charabia.model.Player;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
    private Alert alert;

    public PlayFx(Charabia game, Player player) {
        charabia = game;
        this.player = player;

        alert = new Alert(Alert.AlertType.INFORMATION);

        myPlay();
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
                //if (charabia.isPlay(fieldWord.getText())) {
                    charabia.play(player, charabia.findBestWord()); //// TEST
                    //charabia.play(player, fieldWord.getText());
                    fieldWord.setEditable(false);
                    proposedWord.setDisable(true);
                    if (charabia.isRoundOver()) {
                        roundOver();
                        charabia.nextRound();
                    }
                    fieldWord.setText(fieldWord.getText());
                //} else {
                //    fieldWord.setText("Mot Introuvable");
                //}
            }
        });
    }

    private void roundOver() {
        int countwin = 0;
        alert.setTitle("Fin Du Rounde");
        String gagant = "Les Gagnants du Round : " + '\n';
        for (Player pp : charabia.getRoundWinners()) {
            if (!"".equals(pp.getWordProposed())) {
                gagant += "[" + pp.getName() + "] |_| Score [" + pp.getScore() + "] " + "Mot proposer [" + pp.getWordProposed() + "]" + '\n';
                countwin++;
            }
        }
        if (countwin == 0) {
            gagant += "Aucun Gagnants dans ce Round";
        }
        alert.setHeaderText(gagant);
        alert.showAndWait();
    }

    public void refreshPlay() {
        myPlay();
    }
}
