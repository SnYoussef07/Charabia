/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g41385.charabia.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 41385
 */
public class CharabiaGameTest {
    

    /**
     * Test of isWordPossible method, of class CharabiaGame.
     */
    @Test
    public void testIfFindWord() throws IOException {
        System.out.println("if FindWord");
        List<Tile> list = new ArrayList<>();
        String word = "AHT";
        list.add(new Tile('C', 2));
        list.add(new Tile('H', 2));
        list.add(new Tile('A', 2));
        list.add(new Tile('T', 2));
        
        CharabiaGame instance = new CharabiaGame();

        boolean result = instance.isWordPossible(list, word);
        assertTrue(result);
    }
    
    /**
     * Test of ifNotFindWord method, of class CharabiaGame.
     */
    @Test
    public void testIfNotFindWord() throws IOException {
        System.out.println("if Not FindWord");
        List<Tile> list = new ArrayList<>();
        String word = "ALT";
        list.add(new Tile('C', 2));
        list.add(new Tile('H', 2));
        list.add(new Tile('A', 2));
        list.add(new Tile('T', 2));
        
        CharabiaGame instance = new CharabiaGame();

        boolean result = instance.isWordPossible(list, word);
        assertFalse(result);
    }
    
}
