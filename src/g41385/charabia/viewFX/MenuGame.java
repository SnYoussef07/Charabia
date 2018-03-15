package g41385.charabia.viewFX;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

/**
 *
 * @author 41385
 */
public class MenuGame extends BorderPane {

    private TextField nameFieldOne;
    private HBox hboxNameOne;
    private HBox hboxButton;
    private Button buttonPlay;

    public MenuGame() {
        nameFieldOne = new TextField();
        buttonPlay = new Button("Play");
        hboxNameOne = new HBox();
        hboxButton = new HBox();
        initMenu();
    }

    public void initMenu() {
        Label nameOne = new Label("Nom : ");
        hboxNameOne.getChildren().addAll(nameOne, nameFieldOne);
        hboxButton.getChildren().add(buttonPlay);

        hboxNameOne.setStyle("-fx-background-color: #FFFFFF;");
        hboxButton.setStyle("-fx-background-color: #046380;");

        this.setCenter(hboxNameOne);
        this.setBottom(hboxButton);

        hboxNameOne.setAlignment(Pos.CENTER);
        hboxNameOne.setPadding(new Insets(0, 20, 0, 0));

        hboxButton.setAlignment(Pos.BOTTOM_CENTER);
        hboxButton.setPadding(new Insets(0, 0, 10, 0));
    }
    
    public Button getButton(){
        return this.buttonPlay;
    }
    
    public String getName(){
        return nameFieldOne.getText();
    }
}

