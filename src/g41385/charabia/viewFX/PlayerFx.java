package g41385.charabia.viewFX;

import g41385.charabia.model.Charabia;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 * represents the display of the player list
 *
 * @author 41385
 */
public class PlayerFx extends VBox {

    private final Charabia charabia;
    private final VBox hboxPlayerOne;
    private final VBox hboxPlayerTwo;
    private final Label nameOne;
    private final Label nameTwo;
    private final Label scoreOne;
    private final Label scoreTwo;

    /**
     * Construct PlayerFx
     *
     * @param game instance of CharabiaGame
     */
    public PlayerFx(Charabia game) {
        charabia = game;
        hboxPlayerOne = new VBox();
        hboxPlayerTwo = new VBox();
        hboxPlayerOne.setStyle("-fx-background-color: #639bb6;\n"
                + "-fx-border-radius: 7 7 7 7;\n"
                + "-fx-background-radius: 7 7 7 7;");
        hboxPlayerTwo.setStyle("-fx-background-color: #76b99c;\n"
                + "-fx-border-radius: 7 7 7 7;\n"
                + "-fx-background-radius: 7 7 7 7;");
        nameOne = new Label();
        nameTwo = new Label();
        scoreOne = new Label();
        scoreTwo = new Label();
        setStyleLabel();
        nameOne.setText("Nom : " + charabia.getPlayers().get(0).getName());
        nameTwo.setText("Nom : " + charabia.getPlayers().get(1).getName());
        hboxPlayerOne.setAlignment(Pos.CENTER_RIGHT);
        hboxPlayerTwo.setAlignment(Pos.CENTER_RIGHT);
        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(0, 10, 0, 00));
        this.setSpacing(20);

        myPlayers();
    }

    /**
     * styl the display players
     */
    private void setStyleLabel() {
        nameOne.setStyle("-fx-font-size: 20px;\n"
                + "-fx-font-weight: bold;\n"
                + "-fx-text-fill: #000000;\n"
                + "-fx-effect: dropshadow( gaussian , rgba(255,255,255,0.5)"
                + " , 0,0,0,1 );");
        nameTwo.setStyle("-fx-font-size: 20px;\n"
                + "-fx-font-weight: bold;\n"
                + "-fx-text-fill: #000000;\n"
                + "-fx-effect: dropshadow( gaussian , rgba(255,255,255,0.5)"
                + " , 0,0,0,1 );");
        scoreOne.setStyle("-fx-font-size: 20px;\n"
                + "-fx-font-weight: bold;\n"
                + "-fx-text-fill: #000000;\n"
                + "-fx-effect: dropshadow( gaussian , rgba(255,255,255,0.5)"
                + " , 0,0,0,1 );");
        scoreTwo.setStyle("-fx-font-size: 20px;\n"
                + "-fx-font-weight: bold;\n"
                + "-fx-text-fill: #000000;\n"
                + "-fx-effect: dropshadow( gaussian , rgba(255,255,255,0.5)"
                + " , 0,0,0,1 );");
    }

    /**
     * Display Players
     */
    private void myPlayers() {
        this.getChildren().clear();
        hboxPlayerOne.getChildren().clear();
        hboxPlayerTwo.getChildren().clear();

        scoreOne.setText("Score : " + charabia.getPlayers().get(0).getScore());
        scoreTwo.setText("Score :" + charabia.getPlayers().get(1).getScore());

        hboxPlayerOne.getChildren().addAll(nameOne, scoreOne);
        hboxPlayerTwo.getChildren().addAll(nameTwo, scoreTwo);
        this.getChildren().addAll(hboxPlayerOne, hboxPlayerTwo);
    }

    /**
     * refresh the Players
     */
    public void refreshPlayers() {
        myPlayers();
    }
}
