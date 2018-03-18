package g41385.charabia.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * represents the bag of the game
 *
 * @author 41385
 */
class Bag {

    private final List<Tile> tiles;
    /**
     * Cnnstruct class Bag
     */
    Bag() throws FileNotFoundException {
        this.tiles = new ArrayList();
        initBag();
    }

    /**
     * initialize the Bag
     */
    private void initBag() throws FileNotFoundException {
        File file = new File("letters.txt");
        Scanner readLetters = new Scanner(file);
        readLetters.useDelimiter(",");
        while (readLetters.hasNext()) {
            String letter = readLetters.next();
            String count = readLetters.next();
            String score = readLetters.next();

            for (int i = 0; i < Integer.parseInt(count); i++) {
                tiles.add(new Tile(letter.charAt(0), Integer.parseInt(score)));
            }
        }
        shuffle();
    }

    /**
     * Allows to mix the bag
     */
    private void shuffle() {
        Collections.shuffle(tiles);
    }

    /**
     * Allows you to draw a Tile
     *
     * @return Tile
     */
    Tile draw() {
        return this.tiles.remove(0);
    }

    /**
     * return boolean is Empty.
     *
     * @return boolean
     */
    boolean bagIsEmpty() {
        return this.tiles.isEmpty();
    }

    /**
     * Return tiles
     *
     * @return List<Tile copy of the bag
     */
    List<Tile> getMyBag() {
        List<Tile> tile = new ArrayList(this.tiles);
        return tile;
    }
}
