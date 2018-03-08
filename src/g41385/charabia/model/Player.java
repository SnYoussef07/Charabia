package g41385.charabia.model;

/**
 * represents the PLayer
 * @author 41385
 */
public class Player {

    private String name;
    private int score;
    private String wordProposed;
    private boolean isPlay;

    public Player(String name) {
        if (name == null) {
            throw new IllegalArgumentException("name cannot be null");
        }
        this.name = name;
        this.wordProposed = "";
        this.score = 0;
        this.isPlay = false;
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
    void setWordProposed(String wordProposed) {
        this.wordProposed = wordProposed;
    }
    
    /**
     * Increment the scor.
     *
     * @param score
     */
    void addScore(int score) {
        if (score < 0) {
            throw new IllegalArgumentException("score is negative");
        }
        this.score += score;
    }

    /**
     * Return isplay
     * @return boolean
     */
    boolean getIsPlay() {
        return isPlay;
    }

    void setIsPlay(boolean isPlay) {
        this.isPlay = isPlay;
    }
    
    /**
     * Reset is play
     */
    void rsetIsPlay() {
        this.isPlay = false;
    }  
}
