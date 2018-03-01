package g41385.charabia.model;

/**
 *
 * @author 41385
 */
public class Tile {

    private final char letter;
    private final  int scoring;

    public Tile(char letter, int scoring) {
        this.letter = letter;
        this.scoring = scoring;
    }

    public char getLetter() {
        return letter;
    }

    public int getScoring() {
        return scoring;
    }

    @Override
    public String toString() {
        return "["+letter+"|"+scoring+"]"; // a corrig
    }
    
    
}
