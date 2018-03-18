/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g41385.charabia.model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 41385
 */
public class TableTest {
    
    /**
     * Test of calculatScor method, of class CharabiaGame.
     */
    @Test
    public void testCalculatScor() throws IOException {
        System.out.println("calculatScor");
        String word = "ABC";
        CharabiaGame instance = new CharabiaGame();
        int expResult = 0;

        
        expResult += instance.getTable().getScorAt('A');
        expResult += instance.getTable().getScorAt('B');
        expResult += instance.getTable().getScorAt('C');
        
        int result = instance.getTable().getScore(word);
        assertEquals(expResult, result);
    }

    /**
     * Test of refreshTable method, of class Table.
     */
    @Test
    public void testRefreshTable() throws FileNotFoundException {
        System.out.println("refreshTable");
        Bag bag = new Bag();
        Table instance = new Table(bag);
        String winWord = null ;
        List<Tile> firstTable = new ArrayList<>();
        firstTable = instance.getMyTable();
        
        winWord += instance.getMyTable().get(0);
        winWord += instance.getMyTable().get(1);
        winWord += instance.getMyTable().get(2);
        
        instance.refreshTable(winWord);
        assertNotEquals(instance, firstTable);

    }

  
    
}
