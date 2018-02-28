package g41385.charabia.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 41385
 */
public class Table {

    private List<Tile> myTable;
    private Bag bag;

    public Table() {
        myTable = new ArrayList();
        bag = new Bag();
    }
    
    public void initTable(){
        bag.shuffle();
        myTable.clear();
        for(int i=0;i<10;i++){
            myTable.add(bag.draw());
        }
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
