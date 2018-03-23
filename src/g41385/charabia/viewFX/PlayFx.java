package g41385.charabia.viewFX;

import g41385.charabia.model.Charabia;
import g41385.charabia.model.Player;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

/**
 * represents the action of play 
 * @author g41385
 */
public class PlayFx extends HBox {

    private final Charabia charabia;
    private final Player player;
    private final TextField fieldWord;
    private final Button proposedWord;
    private final Alert alert;

    /**
     * Construct Play
     * @param game instance of CharabiaGame
     * @param player current player
     */
    public PlayFx(Charabia game, Player player) {
        charabia = game;
        this.player = player;
        alert = new Alert(Alert.AlertType.INFORMATION);
        proposedWord = new Button("Proposer");
        fieldWord = new TextField();
        this.setAlignment(Pos.BOTTOM_CENTER);
        this.setPadding(new Insets(20, 20, 20, 20));

        myPlay();
    }

     /**
     * Display play
     */
    public void myPlay() {
        this.getChildren().clear();
        fieldWord.clear();
        fieldWord.setEditable(true);
        fieldWord.setPromptText(charabia.findBestWord());
        proposedWord.setDisable(false);

        this.getChildren().addAll(fieldWord, proposedWord);

        proposedWord.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                if (charabia.isPlay(fieldWord.getText())) {
                    charabia.play(player, fieldWord.getText());
                    fieldWord.setEditable(false);
                    proposedWord.setDisable(true);
                    if (charabia.isRoundOver()) {
                        roundOver();
                        charabia.nextRound();
                    }
                    fieldWord.setText(fieldWord.getText());
                } else {
                    fieldWord.setText("Mot Introuvable");
                }
            }
        });
    }

    /**
     * show the results of the end of the round
     */
    private void roundOver() {
        int countwin = 0;
        alert.setTitle("Fin Du Rounde");
        String gagant = "Les Gagnants du Round : " + '\n';
        for (Player pp : charabia.getRoundWinners()) {
            if (!"".equals(pp.getWordProposed())) {
                gagant += "[" + pp.getName() + "] |_| Score [" + pp.getScore()
                        + "] " + "Mot proposer [" + pp.getWordProposed()+"]"+'\n';
                countwin++;
            }
        }
        if (countwin == 0) {
            gagant += "Aucun Gagnants dans ce Round";
        }
        alert.setHeaderText(gagant);
        alert.showAndWait();
    }

    /**
     * refresh the Play
     */
    public void refreshPlay() {
        myPlay();
    }
}
