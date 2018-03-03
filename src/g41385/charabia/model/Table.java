package g41385.charabia.model;

import java.util.ArrayList;
import java.util.List;

/**
 * represents the Table of the game
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
    }
    
    /**
     * initializes the table with the Tile
     */
    public void initTable(){ /// a coorige enlever que les jeton du gagnat !!!!!!!!!!!!!!!!
        bag.shuffle();
        myTable.clear();
        for(int i=0;i<10;i++){
            myTable.add(bag.draw());
        }
    }

    public List<Tile> getMyTable() {
        List<Tile> tile = this.myTable;
        return  tile;
    }
    

    @Override
    public String toString() {
        String str="";
        str += "--------------------------------------------------------------------------------"+'\n';
        for (Tile tile : this.myTable) {
            str += "-" + tile.toString();
        }
        str += '\n';
        str += "--------------------------------------------------------------------------------"+'\n';
        return str;
    }
    
    

}
