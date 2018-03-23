package g41385.charabia.viewFX;

import g41385.charabia.model.CharabiaGame;
import g41385.charabia.model.Player;
import g41385.charabia.observer.Observer;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * represents the game and these display
 *
 * @author snsmaug
 */
public class GameView extends BorderPane implements Observer {

    private final CharabiaGame charabia;

    private final TableFx tableFx;
    private final PlayerFx playerFx;
    private final BagFx bagFx;
    private final PlayFx playFx;
    private HBox currentHbox;
    private final VBox winnersVbox;

    private Label currentPlayer;

    private final Player playerTest;

    /**
     * Construct GameView
     * @param charabia instance of charabiaGame
     * @param player player current
     */
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

        winnersVbox = new VBox();
        playerTest = player;
        displayGame();

        this.charabia.registerObserver(this);

    }

    /**
     * show current player and background image
     */
    private void displayGame() {
        currentHbox = new HBox();
        currentPlayer = new Label(playerTest.getName());
        currentHbox.getChildren().add(currentPlayer);
        this.setTop(currentHbox);
        currentHbox.setAlignment(Pos.CENTER);
        currentHbox.setPadding(new Insets(170, 0, 0, 0));
        currentPlayer.setStyle("-fx-font-size: 30px;\n"
                + "-fx-font-weight: bold;\n"
                + "-fx-text-fill:  #000000 ;\n"
                + "-fx-effect: dropshadow( gaussian , rgba(0,0,0,0.8) "
                + ", 0,0,0,1 );");
        Image image = new Image(new File("sourcCharabia/fondGame.jpg").toURI().
                toString());
        BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, 
                BackgroundSize.AUTO, false, false, true, false);
        this.setBackground(new Background(new BackgroundImage(image,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                bSize)));
    }

    /**
     * shows the end of the game and the winner.
     */
    private void printEndGame() {
        Image image = new Image(new File("sourcCharabia/charabiaWiner.png").
                toURI().toString());
        BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, 
                BackgroundSize.AUTO, false, false, true, false);
        this.setBackground(new Background(new BackgroundImage(image,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                bSize)));
        List<Label> winners = new ArrayList();

        Label myLabel = new Label("Bravo au Gagnant !");
        myLabel.setStyle("-fx-font-size: 25px;\n"
                + "-fx-font-weight: bold;\n"
                + "-fx-text-fill:  #FFFFFF ;\n"
                + "-fx-effect: dropshadow( gaussian , rgba(0,0,0,0.8) , "
                + "0,0,0,1 );");

        winnersVbox.getChildren().add(myLabel);
        for (int i = 0; i < charabia.getWinners().size(); i++) {
            winners.add(new Label(charabia.getWinners().get(i).getName()));
            winnersVbox.getChildren().add(winners.get(i));
        }
        for (Label label : winners) {
            label.setStyle("-fx-font-size: 25px;\n"
                    + "-fx-font-weight: bold;\n"
                    + "-fx-text-fill:  #FFFFFF ;\n"
                    + "-fx-effect: dropshadow( gaussian , rgba(0,0,0,0.8) , "
                    + "0,0,0,1 );");
        }
        this.setCenter(winnersVbox);
        winnersVbox.setAlignment(Pos.CENTER);
    }

    @Override
    public void update() {
        if (charabia.isGameOver()) {
            this.getChildren().clear();
            printEndGame();
        }

        tableFx.refreshTable();
        playerFx.refreshPlayers();
        bagFx.refreshBag();
        playFx.refreshPlay();
    }

}
