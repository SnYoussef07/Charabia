package g41385.charabia.model;

import java.util.ArrayList;
import java.util.List;

/**
 * represents the player list
 *
 * @author 41385
 */
public class PlayerManager {

    private List<Player> players;
    private int current;

    public PlayerManager() {
        this.players = new ArrayList();
        this.current = 0;
    }

    /**
     * add a player to a list of players
     *
     * @param player
     */
    public void addPlayer(Player player) {
        if (player == null) {
            throw new IllegalArgumentException("player cannot be null");
        }
        players.add(player);
    }

    /**
     * Returns the current player.
     *
     * @return Player.
     */
    public Player getCurrentPlayer() {
        return players.get(current);
    }

    /**
     * Returns the next player.
     */
    public void nextPlayer() {
        current++;
        if (this.current > this.players.size() - 1) {
            this.current = 0;
        }
    }

    /**
     * Return list copy the Player.
     *
     * @return
     */
    public List<Player> getPlayers() {
        List<Player> myPlayer = this.players;
        return myPlayer;
    }
}
