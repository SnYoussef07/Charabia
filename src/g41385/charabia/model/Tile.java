package g41385.charabia.model;

/**
 *
 * @author 41385
 */
class Tile {

    private final MyCharacter letter;
    private final  int scoring;

    public Tile(MyCharacter letter, int scoring) {
        this.letter = letter;
        this.scoring = scoring;
    }

    public MyCharacter getLetter() {
        return letter;
    }

    public int getScoring() {
        return scoring;
    }

    @Override
    public String toString() {
        return "["+letter.getMyLetter()+"|"+scoring+"]";
    }
    
    
}
