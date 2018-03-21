package g41385.charabia.viewFX;

import g41385.charabia.model.CharabiaGame;
import g41385.charabia.model.Player;
import g41385.charabia.observer.Observer;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
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
    private HBox currentHbox;
    private Label currentPlayer;

    private Player playerTest;

    public GameView(CharabiaGame charabia, Player player) {
        this.charabia = charabia;

        tableFx = new TableFx(charabia);
        this.setCenter(tableFx);
        playerFx = new PlayerFx(charabia);
        this.setRight(playerFx);
        bagFx = new BagFx(charabia);
        this.setLeft(bagFx);
        playFx = new PlayFx(charabia, player);
        this.setBottom(playFx);

        playerTest = player;
        currentHbox = new HBox();
        currentPlayer = new Label(playerTest.getName());
        currentHbox.getChildren().add(currentPlayer);
        this.setTop(currentHbox);
        currentHbox.setAlignment(Pos.CENTER);
        currentHbox.setPadding(new Insets(70, 0, 0, 0));
        currentPlayer.setStyle("-fx-font-size: 30px;\n"
                + "-fx-font-weight: bold;\n"
                + "-fx-text-fill:  #419b1a ;\n"
                + "-fx-effect: dropshadow( gaussian , rgba(255,255,255,0.5) , 0,0,0,1 );");

        this.charabia.registerObserver(this);

    }

    @Override
    public void update() {
        if (charabia.isGameOver()) {
            this.getChildren().clear();
        }

        tableFx.refreshTable();
        playerFx.refreshPlayers();
        bagFx.refreshBag();
        playFx.refreshPlay();
    }
}
