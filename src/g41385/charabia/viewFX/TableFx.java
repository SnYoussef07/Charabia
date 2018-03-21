package g41385.charabia.viewFX;

import g41385.charabia.model.Charabia;
import g41385.charabia.model.Tile;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author 41385
 */
public class TableFx extends HBox {

    private List<VBox> hboxTiles;
    private Charabia charabia;
    private String pathCar = null;
    private String pathNum = null;

    public TableFx(Charabia game) {
        charabia = game;
        hboxTiles = new ArrayList();
        this.setMaxWidth(850);
        addBackground();

        myTable();
    }

    private void addBackground() {
        Image image = new Image(new File("sourcCharabia/charabiaTable.png").toURI().toString());
        BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
        this.setBackground(new Background(new BackgroundImage(image,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                bSize)));
    }

    private void myTable() {
        this.getChildren().clear();
        for (VBox hh : hboxTiles) {
            hh.getChildren().clear();
        }

        for (Tile tt : charabia.getListTile()) {
            pathCar = "sourcCharabia/" + tt.getLetter() + ".png";
            pathNum = "sourcCharabia/" + tt.getPoints() + ".png";

            hboxTiles.add(new VBox(new ImageView(new Image(new File(pathCar).toURI().toString())),
                    new ImageView(new Image(new File(pathNum).toURI().toString()))));
        }
        for (VBox hh : hboxTiles) {
            hh.setAlignment(Pos.CENTER);
            hh.setSpacing(-7);
        }
        this.getChildren().addAll(hboxTiles);
        this.setAlignment(Pos.CENTER);
    }

    public void refreshTable() {
        myTable();
    }

}
