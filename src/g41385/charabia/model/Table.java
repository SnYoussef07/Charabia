package g41385.charabia.model;

import java.util.ArrayList;
import java.util.List;

/**
 * represents the Table of the game
 *
 * @author 41385
 */
class Table {

    private final List<Tile> myTable;
    private final Bag bag;
    private boolean ifNotFull;

    /**
     * Construct class Table
     */
    Table(Bag bag) {
        myTable = new ArrayList();
        this.bag = bag;
        ifNotFull = false;
        initTable();
    }

    /**
     * initializes the table with the Tile
     */
    void initTable() {
        for (int i = 0; i < 10; i++) {
            myTable.add(bag.draw());
        }
    }
    
    /**
     * refresh the table according to the winner's word
     *
     * @param winWord winner's word of the player
     */
    void refreshTable(String winWord) {
        if (winWord == null) {
            throw new IllegalArgumentException("winWord cannot be null");
        }
        char[] charWord = winWord.toCharArray();
        if (!"".equals(winWord)) {
            for (int i = 0; i < charWord.length; i++) {
                for (int j = 0; j < this.myTable.size(); j++) {
                    if (charWord[i] == myTable.get(j).getLetter()) {
                        myTable.remove(j);
                        break;
                    }
                }
            }
        } else {
            resetTable();
        }
        ifTableFilled();
    }

    /**
     * if the table can be filled we fill it up to the size of 10 Otherwise we
     * change the attribute ifNotFull.
     */
    private void ifTableFilled() {
        if (((bag.getMyBag().size()) + (myTable.size())) < 10) {
            ifNotFull = true;
        } else {
            while (myTable.size() < 10) {
                myTable.add(bag.draw());
            }
        }
    }

    /**
     * if both players pass the turn, reset the table
     */
    private void resetTable() {
        for (Tile tt : myTable) {
            bag.addTile(tt);
        }
        myTable.clear();
        initTable();
    }

    /**
     * returns the Tile value according to the received character
     *
     * @param myChar
     * @return
     */
    int getScorAt(char myChar) {
        if (myChar == ' ') {
            throw new IllegalArgumentException("myChar cannot be null");
        }
        int scoring = 0;
        for (Tile tt : myTable) {
            if (tt.getLetter() == myChar) {
                scoring = tt.getPoints();
            }
        }
        return scoring;
    }

    /**
     * calculates the score of the received word
     *
     * @param word received
     * @return the score of the word
     */
    int getScore(String word) {
        char[] charWord = word.toCharArray();
        int scor = 0;
        for (int i = 0; i < charWord.length; i++) {
            scor += this.getScorAt(charWord[i]);
        }
        return scor;
    }

   
    /**
     * Return myTable
     *
     * @return List<Tile
     */
    List<Tile> getMyTable() {
        List<Tile> tile = new ArrayList(myTable);
        return tile;
    }

    /**
     * Return ifNotFull
     *
     * @return Boolean
     */
    boolean getIfNotFull() {
        return ifNotFull;
    }
    /**
     * Return siz of the table
     * @return size table
     */
    int size(){
        return this.myTable.size();
    }
    /**
     * return boolean is table full
     * @return is full
     */
    boolean isFull(){
        return myTable.size() > 10;
    }
}
