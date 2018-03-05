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
    private State state;
    private List<Player> players;

    public CharabiaGame() throws FileNotFoundException, IOException {
        this.players = new ArrayList<>();
        this.bag = new Bag();
        this.table = new Table(bag);
        this.dictionnary = new Dictionary();
        this.state = State.CONFIGURE;
    }

    @Override
    public Table getTiles() {  /// car connait pas table comme publique
        return table;
    }

    @Override
    public void play(Player player, String word) { 
        if (state != State.STARTED) {
            throw new IllegalStateException("the player already played");
        }
        if (player.getIsPlay() == false) { //???!!!!!!
            if (table.ifExists(word) || dictionnary.findWord(word)) {
                player.setWordProposed(word);
                player.setIsPlay(true);
            }
        }
        if (isAllPlayerPLay()) { // dans nexRound
            state = State.ROUND_OVER;
            compareSize(players.get(0), players.get(1));
        }
    }

    @Override
    public List<Player> getRoundWinners() {
        if (state != State.ROUND_OVER) {
            throw new IllegalStateException("is not in ROUND_OVER state.");
        }
        return RoundWinnersFind(players.get(0), players.get(1));
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

    @Override
    public void nextRound() {
        if (state != State.ROUND_OVER) {
            throw new IllegalStateException("is game is not in ROUND_OVER state");
        }
        state = State.STARTED;
        resetIsPlay(); // met sit les joueur on jouer a false
    }

    /**
     * Calculates the player score of the proposed word
     *
     * @param player
     */
    private void calculatScor(Player player) {
        char[] charWord = player.getName().toCharArray();
        for (int i = 0; i < charWord.length; i++) {
            player.addScore(this.bag.getScorAt(charWord[i]));
        }
    }

    /**
     * compare the size of the word and return the list of the players
     * who find the longest word
     * @param playerOne propose his word
     * @param playerTwo propose his word
     */
    private List<Player> RoundWinnersFind(Player playerOne, Player playerTwo) { // en faire 2 pour nextRound et Play
        List<Player> playerWinner = new ArrayList();
        if (playerOne.getWordProposed().length() > playerTwo.getWordProposed().length()) {
            playerWinner.add(playerOne);
        } else if (playerOne.getWordProposed().length() == playerTwo.getWordProposed().length()) {
            playerWinner.add(playerOne);
            playerWinner.add(playerTwo);
        } else {
            playerWinner.add(playerTwo);
        }
        return playerWinner;
    }
    
    /**
     * compare the size of the word and return the winner calculate his SCORE
     *
     * @param playerOne propose his word
     * @param playerTwo propose his word
     */
    private void compareSize(Player playerOne, Player playerTwo) { 
        if (playerOne.getWordProposed().length() > playerTwo.getWordProposed().length()) {
            calculatScor(playerOne);
        } else if (playerOne.getWordProposed().length() == playerTwo.getWordProposed().length()) {
            calculatScor(playerOne);
            calculatScor(playerTwo);
        } else {
            calculatScor(playerTwo);
        }
    }

    /**
     * return a boolean that informs us if all players play
     *
     * @return boolean if all player play
     */
    private boolean isAllPlayerPLay() {
        int count = 0;
        boolean isAll = false;
        for (Player pl : players) {
            if (pl.getIsPlay()) {
                count++;
            }
        }
        if (count == 2) {
            isAll = true;
        }
        return isAll;
    }

    /**
     * reset the isPLay attribute of each player to false
     */
    private void resetIsPlay() { // met a false isPLay a mettr au debut d'un round!!!!!!!!!!!!
        for (Player pl : players) {
            pl.rsetIsPlay();
        }
    }

    public Bag getBag() {
        return bag;
    }
}
