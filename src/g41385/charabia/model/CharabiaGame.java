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
    private int current;
    private boolean gameOver;

    public CharabiaGame() throws FileNotFoundException, IOException {
        this.players = new ArrayList<>();
        this.bag = new Bag();
        this.table = new Table(bag);
        this.dictionnary = new Dictionary();
        this.state = State.CONFIGURE;
        current = 0;
        gameOver = false;
    }

    @Override
    public Table getTiles() {
        return table;
    }

    @Override
    public List<Tile> getListTile() {
        return this.table.getMyTable();
    }

    @Override
    public void play(Player player, String word) {
        if (state != State.STARTED) {
            throw new IllegalStateException("the player already played");
        }
        if (player.getIsPlay() == false) { //SI DEJA JOUER
            player.setIsPlay(true);

            if (!"pass".equals(word)) {
                player.setWordProposed(word);
                System.out.println("Mot accepter"); //a enlever
            }
            nextPlayer();
        }
        if (isAllPlayerPLay()) { // fin du round
            state = State.ROUND_OVER;
            compareSize(players.get(0), players.get(1));
        }
    }

    @Override
    public boolean isPlay(String word) {
        boolean play = false;
        /*if ((table.ifExists(word) && dictionnary.findWord(word)) || word.equals("pass")) {
            play = true;
        }*/
        if ((this.ifExists(table.getMyTable() , word) && dictionnary.findWord(word)) || word.equals("pass")) {
            play = true;
        }
        return play;
    }

    @Override
    public List<Player> getRoundWinners() {
        if (state != State.ROUND_OVER) {
            throw new IllegalStateException("is not in ROUND_OVER state.");
        }
        return RoundWinnersFind(players.get(0), players.get(1));

    }

    @Override
    public Player joinGame(String playerName) {
        if (state != State.CONFIGURE) {
            throw new IllegalStateException("when game is not in state CONFIGURE");
        }
        this.players.add(new Player(playerName));
        if (players.size() == 2) { // si tt les joueur on rejoint
            state = State.STARTED;
        }
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
        table.refreshTable(getRoundWinners().get(current).getWordProposed()); // refrechi la table avec le gagant *plus tard generé aleatoir
        this.refrshWord();
        state = State.STARTED;
        resetIsPlay();
    }

    @Override
    public boolean isRoundOver() {
        boolean isRoundOver = false;
        if (state == State.ROUND_OVER) {
            isRoundOver = true;
        }
        return isRoundOver;
    }

    @Override
    public boolean isGameOver() {
        if (bag.bagIsEmpty() || table.getIfNotFull()) {
            gameOver = true;
        }
        return gameOver;
    }

    @Override
    public List<Player> getWinners() {
        List<Player> playerWinner = new ArrayList();
        if (players.get(0).getScore() > players.get(1).getScore()) {
            playerWinner.add(players.get(0));
        } else if (players.get(0).getScore() < players.get(1).getScore()) {
            playerWinner.add(players.get(1));
        } else {
            playerWinner.add(players.get(0));
            playerWinner.add(players.get(1));
        }
        return playerWinner;
    }

    @Override
    public int numberTiles() {
        return bag.getMyBag().size();
    }

    /**
     * Calculates the player score of the proposed word
     *
     * @param player
     */
    private void calculatScor(Player player) {
        char[] charWord = player.getWordProposed().toCharArray();
        for (int i = 0; i < charWord.length; i++) {
            player.addScore(this.bag.getScorAt(charWord[i]));
        }
    }

    /**
     * compare the size of the word and return the list of the players who find
     * the longest word
     *
     * @param playerOne propose his word
     * @param playerTwo propose his word
     */
    private List<Player> RoundWinnersFind(Player playerOne, Player playerTwo) {
        List<Player> playerWinner = new ArrayList();
        if (playerOne.getWordProposed().length() > playerTwo.getWordProposed().length()) {
            playerWinner.add(playerOne);
        } else if (playerOne.getWordProposed().length() == playerTwo.getWordProposed().length()) {
            playerWinner.add(playerOne);
            playerWinner.add(playerTwo);
        } else if (playerOne.getWordProposed().length() < playerTwo.getWordProposed().length()) {
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
        } else if (playerOne.getWordProposed().length() < playerTwo.getWordProposed().length()) {
            calculatScor(playerTwo);
        } else {
            calculatScor(playerOne);
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
    private void resetIsPlay() {
        for (Player pl : players) {
            pl.rsetIsPlay();
        }
    }

    @Override
    public Player getCurrentPlayer() {
        return players.get(current);
    }

    /**
     * Returns the next player.
     */
    private void nextPlayer() {
        current++;
        if (this.current > this.players.size() - 1) {
            this.current = 0;
        }
    }

    /**
     * refresh the player's name for the next round
     */
    private void refrshWord() {
        for (Player pp : players) {
            pp.setWordProposed("");
        }
    }

    public void setGameOver() {
        this.gameOver = true;
    }

    @Override
    public void wordNotFound() {
        if (this.bag.getMyBag().size() < 10 && this.bag.getMyBag().size() > 0) {
            List<Tile> myTiles = new ArrayList<>();
            myTiles.addAll(bag.getMyBag());
            myTiles.addAll(table.getMyTable());

            if (!findWordDico(myTiles)) {
                setGameOver();
            }
        }
    }

    /**
     * receives a list and checks if a dictionary word is found in the list
     *
     * @param list of the Tile
     * @return if find word in List
     */
    private boolean findWordDico(List<Tile> ll) {
        String test = "";
        boolean find = false;
        for (Tile tt : ll) {
            test += tt.getChar();
        }
        for (String s : dictionnary.getMyDico()) {
            /*if (test.contains(s)) {               //reverifier 
                find = true;
            }*/
            if (this.ifExists(ll , s)) {
                find = true;
            }
        }
        return find;
    }

    @Override
    public String recherchBestWord() { // Geré le meilleur Score !!!!!!!!!!!!! 
        //String test = "";
        String ret = "";
        /*for (Tile tt : table.getMyTable()) {
            test += tt.getChar();
        }*/
        List<String> monTest = new ArrayList<>();
        for (String s : dictionnary.getMyDico()) {
            /*if (test.contains(s)) {
                monTest.add(s);
            }*/
            if (this.ifExists(table.getMyTable(), s)) {
                monTest.add(s);
            }
        }
        int max = 0;
        for (int i = 0; i < monTest.size(); i++) {
            if (monTest.get(i).length() > max) {
                max = monTest.get(i).length();
                ret = monTest.get(i);
            }
        }
        return ret;
    }

    @Override
    public String recherchMinWord() { // a SUPPPP 
        String test = "";
        String ret = "";
        for (Tile tt : table.getMyTable()) {
            test += tt.getChar();
        }
        for (String s : dictionnary.getMyDico()) {
            /*if (test.contains(s)) {
                ret = s;
            }*/
            if (this.ifExists(table.getMyTable(), s)) {
                ret = s;
            }
        }
        return ret;
    }
    
     /**
     * returns a boolean that says if the proposed word exists in the table
     *
     * @param word
     * @return boolean
     */
    private boolean ifExists(List<Tile> list , String word) {           //MODIF DOC
        if (word == null) {
            throw new IllegalArgumentException("word cannot be null");
        }
        char[] charWord = word.toCharArray();
        List<Character> copyTableCHar = new ArrayList();
        boolean okProfond = false;
        boolean okFacade = true;
        for (Tile tt : list) {
            copyTableCHar.add(tt.getChar());
        }
        if (charWord.length <= list.size()) {
            for (int i = 0; i < charWord.length; i++) {
                for (int j = 0; j < copyTableCHar.size(); j++) {
                    if (charWord[i] == copyTableCHar.get(j)) {
                        okProfond = true;
                        copyTableCHar.remove(j);
                        break;
                    }
                }
                if (okProfond == false) {
                    okFacade = false;
                }
                okProfond = false;
            }
        }
        return okFacade;
    }

}
