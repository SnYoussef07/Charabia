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
        bag.shuffle();
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
                    if (charWord[i] == myTable.get(j).getChar()) {
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
     * if the table can be filled we fill it up to the size of 10
     * Otherwise we change the attribute ifNotFull.
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
            bag.getMyBag().add(tt);
        }
        myTable.clear();
        initTable();
    }

    /**
     * Return myTable
     *
     * @return List<Tile
     */
    List<Tile> getMyTable() {
        List<Tile> tile = this.myTable;
        return tile;
    }

    /**
     * Return ifNotFull
     * @return Boolean
     */
    boolean getIfNotFull() {
        return ifNotFull;
    }
}
