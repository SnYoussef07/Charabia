package g41385.charabia.viewFX;

import g41385.charabia.model.Charabia;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author 41385
 */
public class PlayerFx extends VBox {

    private Charabia charabia;
    private HBox hboxPlayerOne;
    private HBox hboxPlayerTwo;

    public PlayerFx(Charabia game) {
        charabia = game;
        hboxPlayerOne = new HBox();
        hboxPlayerTwo = new HBox();
        myPlayers();
    }

    private void myPlayers() {
        this.getChildren().clear();
        hboxPlayerOne.getChildren().clear();
        hboxPlayerTwo.getChildren().clear();
        
        Label nameOne = new Label("name = " + charabia.getPlayers().get(0).getName() + " || ");
        Label nameTwo = new Label("name = " + charabia.getPlayers().get(1).getName() + " || ");
        Label scoreOne = new Label("Score = " + charabia.getPlayers().get(0).getScore());
        Label scoreTwo = new Label("Score = " + charabia.getPlayers().get(1).getScore());
        
        hboxPlayerOne.getChildren().addAll(nameOne, scoreOne);
        hboxPlayerTwo.getChildren().addAll(nameTwo, scoreTwo);
        this.getChildren().addAll(hboxPlayerOne, hboxPlayerTwo);
        hboxPlayerOne.setAlignment(Pos.CENTER_RIGHT);
        hboxPlayerTwo.setAlignment(Pos.CENTER_RIGHT);
        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(0, 10, 0, 00));
    }
    
    public void refreshPlayers() {
        myPlayers();
    }
}
