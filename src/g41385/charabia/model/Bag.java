package g41385.charabia.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * represents the bag of the game
 *
 * @author 41385
 */
class Bag {

    private final List<Tile> myBag;
    private int nbrRandom;
    private MyCharacter myChar;

    /**
     * Cnnstruct class Bag
     */
    Bag() {
        this.myBag = new ArrayList();
        initBag();
    }

    /**
     * initialize the Bag
     */
    private void initBag() {
        Random rand = new Random();
        for (int i = 65; i < 90; i++) { //A To Z
            myChar = new MyCharacter((char) i);
            nbrRandom = 1 + (int) (Math.random() * ((10 - 1) + 1));
            for (int j = 0; j < myChar.getMultip(); j++) {
                this.myBag.add(new Tile(myChar, nbrRandom));
            }
        }
    }

    /**
     * Allows to mix the Deck.
     */
    void shuffle() {
        Collections.shuffle(myBag);
    }

    /**
     * Allows you to draw a Tile
     *
     * @return Tile
     */
    Tile draw() {
        return this.myBag.remove(0);
    }

    /**
     * return boolean is Empty.
     * @return boolean
     */
    boolean bagIsEmpty() {
        return this.myBag.isEmpty();
    }
    
    /**
     * Adds a character and the number of times it appears
     * @param letter
     * @param multip 
     */
    void addTile(char letter , int multip){
        if (multip < 0 || letter == ' ') {
            throw new IllegalArgumentException("multip is negative and letter can not be empty");
        }
        myChar = new MyCharacter(letter);
        nbrRandom = 1 + (int) (Math.random() * ((10 - 1) + 1));
        for(int i=0;i<multip;i++){
            this.myBag.add(new Tile(new MyCharacter(letter),nbrRandom));
        }
    }
    /**
     * Return myBag
     * @return List<Tile
     */
    List<Tile> getMyBag() {
        List<Tile> tile = this.myBag;
        return tile;
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
