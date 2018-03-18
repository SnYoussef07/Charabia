package g41385.charabia.model;

/**
 * represents the game tile
 * @author 41385
 */
public class Tile {

    private final char letter;
    private final  int points;

    /**
     * Cnnstruct class Tile
     * @param letter
     * @param scoring 
     */
    public Tile(char letter, int scoring) {
        if (scoring < 0) {
            throw new IllegalArgumentException("scoring cannot be less than");
        }
        this.letter = letter;
        this.points = scoring;
    }
    /**
     * Return points
     * @return int
     */
    public int getPoints() {return points;}
    /**
     * Return character Tile
     * @return Char
     */
    public char getLetter(){return this.letter;}
}
