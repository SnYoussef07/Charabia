package g41385.charabia.model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 41385
 */
public class CharabiaGame implements Charabia {

    private Table table;
    private Bag bag;
    private Dictionary dictionnary;
    private State state = State.CONFIGURE;
    private PlayerManager playerManag;

    private boolean configure = false;
    private boolean started = true;
    private boolean game_over = true;
    private boolean round_over = true;

    public CharabiaGame() throws FileNotFoundException, IOException {
        this.playerManag = new PlayerManager();

        this.bag = new Bag();
        this.table = new Table(bag);
        this.dictionnary = new Dictionary();
    }

    @Override
    public List<Tile> getTiles() {
        return bag.getMyBag();
    }

    @Override
    public void play(Player player, String word) {
        if (state == State.STARTED) {

        }
        if (dictionnary.findWord(word) || table.ifExists(word)) {

        }
    }

    @Override
    public void joinGame(String playerName) { // ajout EXCEPTIOÀN SI DEJA JOUEUR AVEC LE MEME NOM , changment ca ne retourne pas de player mais ajoute ds la liste  
        if (!configure) {
            throw new IllegalStateException("when game is not in state CONFIGURE");
        }
        playerManag.addPlayer(new Player(playerName));
    }

    @Override
    public List<Player> getPlayers() {
        return playerManag.getPlayers();
    }

    /**
     * Calculates the player score of the proposed word
     * @param player
     * @param word 
     */
    public void calculatScor(Player player, String word) {
        char[] charWord = word.toCharArray();
        for (int i = 0; i < charWord.length; i++) {
            player.addScore(this.bag.getScorAt(charWord[i]));
        }
    }

    public Bag getBag() {
        return bag;
    }

    public Table getTable() {
        return table;
    }
    
    

}
