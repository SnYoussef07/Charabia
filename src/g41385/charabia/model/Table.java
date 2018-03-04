package g41385.charabia.model;

import java.util.ArrayList;
import java.util.List;

/**
 * represents the Table of the game
 *
 * @author 41385
 */
public class Table {

    private List<Tile> myTable;
    private Bag bag;

    /**
     * Construct class Table
     */
    public Table() {
        myTable = new ArrayList();
        bag = new Bag();
        initTable();
    }

    /**
     * initializes the table with the Tile
     */
    public void initTable() {
        bag.shuffle();
        for (int i = 0; i < 10; i++) {
            myTable.add(bag.draw());
        }
    }

    public boolean ifExists(String word) {
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
                    }
                }
                if (okProfond == false) {
                    okFacade = false;
                }
                okProfond = false;
            }
        }
        return okFacade;
    }

    public List<Tile> getMyTable() {
        List<Tile> tile = this.myTable;
        return tile;
    }

    @Override
    public String toString() {
        String str = "";
        str += "--------------------------------------------------------------------------------" + '\n';
        for (Tile tile : this.myTable) {
            str += "-" + tile.toString();
        }
        str += '\n';
        str += "--------------------------------------------------------------------------------" + '\n';
        return str;
    }

}
