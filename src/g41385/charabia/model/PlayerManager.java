package g41385.charabia.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 41385
 */
public class PlayerManager {

    private List<Player> players;
    private int current;

    
    public void addPlayer(Player player){
        
    }

    /**
     * Returns the current player.
     * @return Player.
     */
    Player getCurrentPlayer() {
        return players.get(current);
    }

    /**
     * Returns the next player.
     */
    void nextPlayer() {
        current++;
        if (this.current > this.players.size() - 1) {
            this.current = 0;
        }
    }

    /**
     * Return list copy the Player.
     * @return
     */
    public List<Player> getPlayers() {
        List<Player> myPlayer = this.players;
        return myPlayer;
    }
}
