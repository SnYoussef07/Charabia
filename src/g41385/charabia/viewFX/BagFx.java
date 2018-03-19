package g41385.charabia.viewFX;

import g41385.charabia.model.Charabia;
import java.io.File;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

/**
 *
 * @author 41385
 */
public class BagFx extends VBox {

    private Image image;
    private Label size;
    private Charabia charabia;

    public BagFx(Charabia game) {
        image = new Image(new File("sourcCharabia/bag.png").toURI().toString());
        charabia = game;
        size = new Label();
        size.setStyle("-fx-font-size: 15px;\n"
                + "-fx-font-weight: bold;\n"
                +"-fx-text-fill: #000000;\n"
                + "-fx-effect: dropshadow( gaussian , rgba(255,255,255,0.5) , 0,0,0,1 );");
        
        myBag();
    }

    public void myBag() {
        this.getChildren().clear();
        ImageView imageView = new ImageView(image);
        this.getChildren().add(imageView);
        size.setText("" + charabia.numberTiles());
        this.getChildren().add(size);
        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(0, -120, 0, 10));
    }

    public void refreshBag() {
        myBag();
    }

}
