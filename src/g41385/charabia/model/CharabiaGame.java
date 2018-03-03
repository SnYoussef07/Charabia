package g41385.charabia.model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author 41385
 */
public class CharabiaGame implements Charabia{ 

    private Table table;
    private Bag bag;
    private Dictionary dictionnary;
    private boolean isOver = false;

    public CharabiaGame() throws FileNotFoundException, IOException {
        this.table = new Table();
        this.bag = new Bag();
        this.dictionnary = new Dictionary();
    }
    
    
  
    @Override
    public List<Tile> getTiles() {
        return table.getMyTable();
    }
    
    
}
