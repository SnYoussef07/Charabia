/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g41385.charabia.model;

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
     * Test of refreshTable method, of class Table.
     */
    @Test
    public void testRefreshTable() {
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
