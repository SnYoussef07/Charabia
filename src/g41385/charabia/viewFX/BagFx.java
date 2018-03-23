package g41385.charabia.viewFX;

import g41385.charabia.model.Charabia;
import java.io.File;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

/**
 * Represents the number of tiles in the bag
 * @author 41385
 */
public class BagFx extends VBox {

    private final Image image;
    private final Label size;
    private final Charabia charabia;
    private final ImageView imageView;

    /**
     * Construct BagFx
     * @param game instance of charabiaGame
     */
    public BagFx(Charabia game) {
        image = new Image(new File("sourcCharabia/bag.png").toURI().toString());
        charabia = game;
        size = new Label();
        size.setStyle("-fx-font-size: 15px;\n"
                + "-fx-font-weight: bold;\n"
                +"-fx-text-fill: #000000;\n"
                + "-fx-effect: dropshadow( gaussian , "
                + "rgba(255,255,255,0.5) , 0,0,0,1 );");
        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(0, 0, 0, 10));
        imageView = new ImageView(image);
        
        myBag();
    }

    /**
     * Display Bag
     */
    public void myBag() {
        this.getChildren().clear();
        
        this.getChildren().add(imageView);
        size.setText("" + charabia.numberTiles());
        this.getChildren().add(size);
    }

    /**
     * refresh the bag 
     */
    public void refreshBag() {
        myBag();
    }

}
