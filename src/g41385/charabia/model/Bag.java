package g41385.charabia.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author 41385
 */
public class Bag {

    private List<Tile> myBag;

    public Bag() {
        this.myBag = new ArrayList();
        initBag();
    }

    private void initBag() {
        Random rand = new Random();
        int nbrRandom = 0;
        char c;

        for (int i = 0; i < 50; i++) {
            nbrRandom = 1 + (int) (Math.random() * ((15 - 1) + 1));
            c = (char) (rand.nextInt(26) + 97); // 97 debut (a) jsk z
            
            this.myBag.add(new Tile(c, nbrRandom));
        }
    }

    @Override
    public String toString() {
        String stTile = "";
        int i =0;
        for (Tile tile : this.myBag) {
            stTile += i + " " + tile.toString() + '\n';
            i++;
        }
        return stTile;
    }
    
    

}
