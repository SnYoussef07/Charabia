package g41385.charabia.viewFX;

import java.io.File;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;

/**
 * represents the waiting page of another player
 * @author 41385
 */
public class WaitOtherPlayer extends BorderPane {

    private final Image image;

    /**
     * Construct WaitOtherPlayer
     */
    public WaitOtherPlayer() {
        image = new Image(new File("sourcCharabia/sablier.gif")
                .toURI().toString());
        
        BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, 
                BackgroundSize.AUTO, false, false, true, false);

        this.setBackground(new Background(new BackgroundImage(image,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                bSize)));
    }

}
