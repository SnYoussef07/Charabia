package g41385.charabia.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 *
 * @author 41385
 */
public class Bag {

    private List<Tile> myBag;
    private int nbrRandom;
    private char c;

    Bag() {
        this.myBag = new ArrayList();
        initBag();
    }

    private void initBag() {
        Random rand = new Random();
        for (int i = 0; i < 100; i++) {
            nbrRandom = 1 + (int) (Math.random() * ((10 - 1) + 1));
            /*c = (char) (rand.nextInt(26) + 97);
            this.myBag.add(new Tile(c, nbrRandom));*/
            //this.myBag.add(new Tile(new MyCharacter('A', 9), nbrRandom));
            for (int j = 65; j < 122; j++) {
                MyCharacter mm = new MyCharacter((char) j);
                nbrRandom = 1 + (int) (Math.random() * ((10 - 1) + 1));
                for(int v=0;v<mm.getMultip();v++){
                    this.myBag.add(new Tile(mm, 2));
                }
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(myBag);
    }

    public Tile draw() {
        return this.myBag.remove(0);
    }

    public boolean bagIsEmpty() {
        return this.myBag.isEmpty();
    }

    @Override
    public String toString() {
        String stTile = "";
        int i = 0;
        for (Tile tile : this.myBag) {
            stTile += i + "  " + tile.toString() + '\n';
            i++;
        }
        return stTile;
    }

}
