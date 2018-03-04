package g41385.charabia.model;

/**
 * represents the game tile
 * @author 41385
 */
class Tile {

    private final MyCharacter letter;
    private final  int scoring;

    /**
     * Cnnstruct class Tile
     * @param letter
     * @param scoring 
     */
    Tile(MyCharacter letter, int scoring) {
        if (letter == null || scoring < 0) {
            throw new IllegalArgumentException("letter cannot be null and scoring cannot be less than");
        }
        this.letter = letter;
        this.scoring = scoring;
    }
    /**
     * Return letter
     * @return MyCharacter
     */
    public MyCharacter getLetter() {return letter;}
    /**
     * Return scoring
     * @return int
     */
    public int getScoring() {return scoring;}
    /**
     * Return character Tile
     * @return Char
     */
    public char getChar(){return this.letter.getMyLetter();}

    @Override
    public String toString() {
        return "["+letter.getMyLetter()+"|"+scoring+"]";
    }
    
    
}
