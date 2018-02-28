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

    public Bag() {
        this.myBag = new ArrayList();
        initBag();
    }

    private void initBag() {
        Random rand = new Random();
        for (int i = 0; i < 50; i++) {
            nbrRandom = 1 + (int) (Math.random() * ((9 - 1) + 1));
            c = (char) (rand.nextInt(26) + 97); // 97 debut (a) jsk z
            this.myBag.add(new Tile(c, nbrRandom));
        }
    }
    
    public void shuffle() {
        Collections.shuffle(myBag);
    }
    
    public Tile draw(){
        return this.myBag.remove(0);
    }
    
    public boolean bagIsEmpty(){
        return this.myBag.isEmpty();
    }

    @Override
    public String toString() {
        String stTile = "";
        int i =0;
        for (Tile tile : this.myBag) {
            stTile += i + "  " + tile.toString() + '\n';
            i++;
        }
        return stTile;
    }
    
    
    

}
