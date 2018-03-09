package g41385.charabia.model;

import java.util.ArrayList;
import java.util.List;

/**
 * represents the Table of the game
 *
 * @author 41385
 */
class Table {

    private List<Tile> myTable;
    private Bag bag;
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
     * returns a boolean that says if the proposed word exists in the table
     *
     * @param word
     * @return boolean
     */
    /*boolean ifExists(String word) {         //dEPLACER DANS CHARABIA gAME
        if (word == null) {
            throw new IllegalArgumentException("word cannot be null");
        }
        char[] charWord = word.toCharArray();
        List<Character> copyTableCHar = new ArrayList();
        boolean okProfond = false;
        boolean okFacade = true;
        for (Tile tt : myTable) {
            copyTableCHar.add(tt.getChar());
        }
        if (charWord.length <= myTable.size()) {
            for (int i = 0; i < charWord.length; i++) {
                for (int j = 0; j < copyTableCHar.size(); j++) {
                    if (charWord[i] == copyTableCHar.get(j)) {
                        okProfond = true;
                        copyTableCHar.remove(j);
                        break;
                    }
                }
                if (okProfond == false) {
                    okFacade = false;
                }
                okProfond = false;
            }
        }
        return okFacade;
    }*/

    /**
     * refresh the table according to the winner's word If no player can find a
     * word, reset the table
     *
     * @param winWord
     */
    void refreshTable(String winWord) {
        if (winWord == null) {
            throw new IllegalArgumentException("winWord cannot be null");
        }
        char[] charWord = winWord.toCharArray();
        if (!"".equals(winWord)){
            for (int i = 0; i < charWord.length; i++) {
                for (int j = 0; j < this.myTable.size(); j++) {
                    if (charWord[i] == myTable.get(j).getChar()) {
                        myTable.remove(j);
                        break;
                    }
                }
            }
        } else {
            for (Tile tt : myTable) {
                bag.getMyBag().add(tt);
            }
            myTable.clear();
            initTable();
        }
        if (((bag.getMyBag().size()) + (myTable.size())) < 10) {
            ifNotFull = true;
        } else {
            while (myTable.size() < 10) {
                myTable.add(bag.draw());
            }
        }
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
     * rETURN IFnOTfULL
     *
     * @return Boolean
     */
    boolean getIfNotFull() {
        return ifNotFull;
    }
}
