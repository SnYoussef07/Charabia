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
    private List<Player> players;
    
    public CharabiaGame() throws FileNotFoundException, IOException {
        this.players = new ArrayList<>();
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
    public Player joinGame(String playerName) { // ajout EXCEPTIOÀN SI DEJA JOUEUR AVEC LE MEME NOM
        if (state != State.CONFIGURE) {
            throw new IllegalStateException("when game is not in state CONFIGURE");
        }
        this.players.add(new Player(playerName));
        return this.players.get(players.size() - 1); // r'envoi le drnier player ajouter 
    }

    @Override
    public List<Player> getPlayers() {
        return this.players;
    }

    /**
     * Calculates the player score of the proposed word
     * @param player
     */
    private void calculatScor(Player player) {
        char[] charWord = player.getName().toCharArray();
        for (int i = 0; i < charWord.length; i++) {
            player.addScore(this.bag.getScorAt(charWord[i]));
        }
    }
    
    /**
     * compare the size of the word and return the winner
     * @param playerOne propose his word
     * @param playerTwo propose his word
     * @return return the winner
     */
    public Player compareSize(Player playerOne , Player playerTwo){
        Player playerWinner;
        if(playerOne.getWordProposed().length() > playerTwo.getWordProposed().length()){
            playerWinner = playerOne;
        }else{
            playerWinner = playerTwo;
        }
        return playerWinner;
    }

    public Bag getBag() {
        return bag;
    }

    public Table getTable() {
        return table;
    }
    
    

}
