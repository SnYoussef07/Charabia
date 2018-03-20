package g41385.charabia.viewFX;

import g41385.charabia.model.CharabiaGame;
import g41385.charabia.model.Player;
import g41385.charabia.observer.Observer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

/**
 *
 * @author snsmaug
 */
public class GameView extends BorderPane implements Observer {

    private CharabiaGame charabia;

    private TableFx tableFx;
    private PlayerFx playerFx;
    private BagFx bagFx;
    private PlayFx playFx;

    private Player playerTest;

    public GameView(CharabiaGame charabia, Player player) {
        this.charabia = charabia;

        tableFx = new TableFx(charabia);
        this.setCenter(tableFx);
        playerFx = new PlayerFx(charabia);
        this.setTop(playerFx);
        bagFx = new BagFx(charabia);
        this.setLeft(bagFx);
        playFx = new PlayFx(charabia, player);
        this.setBottom(playFx);

        playerTest = player;
        this.charabia.registerObserver(this);

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
            bagFx.refreshBag();
        }*/
        
        tableFx.refreshTable();
        playerFx.refreshPlayers();
        bagFx.refreshBag();
        playFx.refreshPlay();
    }
}
