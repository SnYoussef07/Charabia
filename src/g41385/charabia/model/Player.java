package g41385.charabia.model;

/**
 * represents the PLayer
 * @author 41385
 */
public class Player {

    private String name;
    private int score;

    public Player(String name) {
        if (name == null) {
            throw new IllegalArgumentException("name cannot be null");
        }
        this.name = name;
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
