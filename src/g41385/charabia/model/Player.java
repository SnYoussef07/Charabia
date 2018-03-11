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
     * @return String name
     */
    public String getName() {
        return name;
    }

    /**
     * Return Score
     *
     * @return int score
     */
    public int getScore() {
        return score;
    }

    /**
     * Return wordProposed
     * @return String word Proposed
     */
    public String getWordProposed() {
        return wordProposed;
    }
    /**
     * set word proposed
     * @param wordProposed new word proposed
     */
    void setWordProposed(String wordProposed) {
        this.wordProposed = wordProposed;
    }
    
    /**
     * Increment the scor.
     *
     * @param score new value
     */
    void addScore(int score) {
        if (score < 0) {
            throw new IllegalArgumentException("score is negative");
        }
        this.score += score;
    }

    /**
     * Return isplay
     * @return boolean isplay
     */
    boolean getIsPlay() {
        return isPlay;
    }
    /**
     * set is player is play
     * @param isPlay new value
     */
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
