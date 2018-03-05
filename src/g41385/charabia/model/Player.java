package g41385.charabia.model;

/**
 * represents the PLayer
 * @author 41385
 */
public class Player {

    private String name;
    private int score;
    private String wordProposed;

    public Player(String name) {
        if (name == null) {
            throw new IllegalArgumentException("name cannot be null");
        }
        this.name = name;
        this.wordProposed = "";
        this.score = 0;
    }

    /**
     * Return Name
     *
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * Return Score
     *
     * @return int
     */
    public int getScore() {
        return score;
    }

    /**
     * Return wordProposed
     * @return String
     */
    public String getWordProposed() {
        return wordProposed;
    }
    /**
     * set word proposed
     * @param wordProposed 
     */
    public void setWordProposed(String wordProposed) {
        this.wordProposed = wordProposed;
    }
    
    /**
     * Increment the scor.
     *
     * @param score
     */
    public void addScore(int score) {
        if (score < 0) {
            throw new IllegalArgumentException("score is negative");
        }
        this.score += score;
    }

}
