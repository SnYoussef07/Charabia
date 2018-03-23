package g41385.charabia.viewFX;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

/**
 * represents the game's menu where the player introduces their name.
 * @author 41385
 */
public class MenuGame extends BorderPane {

    private final TextField nameFieldOne;
    private final HBox hboxNameOne;
    private final HBox hboxTitle;
    private final HBox hboxButton;
    private final Button buttonPlay;
    private final Label title;

    /**
     * Construct MenuGame
     */
    public MenuGame() {
        nameFieldOne = new TextField();
        buttonPlay = new Button("Play");
        hboxNameOne = new HBox();
        hboxButton = new HBox();
        hboxTitle = new HBox();
        title = new Label("Charabia.");
        initMenu(); 
    }

    /**
     * Display menu Game
     */
    public void initMenu() {
        Label nameOne = new Label("Nom : ");
        hboxNameOne.getChildren().addAll(nameOne, nameFieldOne);
        hboxButton.getChildren().add(buttonPlay);
        hboxTitle.getChildren().add(title);

        this.setTop(hboxTitle);
        this.setCenter(hboxNameOne);
        this.setBottom(hboxButton);

        hboxTitle.setAlignment(Pos.TOP_CENTER);
        hboxNameOne.setAlignment(Pos.CENTER);
        hboxNameOne.setPadding(new Insets(0, 20, 0, 0));
        hboxTitle.setPadding(new Insets(80, 0, 0, 0));

        hboxButton.setAlignment(Pos.BOTTOM_CENTER);
        hboxButton.setPadding(new Insets(0, 0, 10, 0));

        title.setStyle("-fx-font-size: 50px;\n"
                + "-fx-font-weight: bold;\n"
                +"-fx-text-fill: #FFFFFF;\n"
                + "-fx-effect: dropshadow( gaussian , "
                + "rgba(255,255,255,0.5) , 0,0,0,1 );");
        nameOne.setStyle("-fx-font-size: 15px;\n"
                + "-fx-font-weight: bold;\n"
                +"-fx-text-fill: #FFFFFF;\n"
                + "-fx-effect: dropshadow( gaussian , "
                + "rgba(255,255,255,0.5) , 0,0,0,1 );");
    }

    /**
     * returns button of play
     * @return button
     */
    public Button getButton() {
        return this.buttonPlay;
    }

    /**
     * returns the introduced name
     * @return name
     */
    public String getName() {
        return nameFieldOne.getText();
    }
}
