package g41385.charabia.model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a game of Charabia.
 *
 * @author 41385
 */
public class CharabiaGame implements Charabia {

    private final Table table;
    private final Bag bag;
    private final Dictionary dictionnary;
    private State state;
    private final List<Player> players;
    private boolean gameOver;

    public CharabiaGame() throws FileNotFoundException, IOException {
        this.players = new ArrayList<>();
        this.bag = new Bag();
        this.table = new Table(bag);
        this.dictionnary = new Dictionary();
        this.state = State.CONFIGURE;
        gameOver = false;
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
        if (player.getIsPlay() == false) {
            player.setIsPlay(true);

            if (!"pass".equals(word)) {
                player.setWordProposed(word);
            }
        }
        if (isAllPlayerPLay()) {
            state = State.ROUND_OVER;
            calculatScorWinner(RoundWinnersFind(players.get(0), players.get(1)));
        }
    }

    @Override
    public boolean isPlay(String word) {
        boolean play = false;
        if ((this.isWordPossible(table.getMyTable(), word) && dictionnary.findWord(word)) || word.equals("pass")) {
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
        if (players.size() == 2) {
            state = State.STARTED;
        }
        return this.players.get(players.size() - 1);
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

        table.refreshTable(getRoundWinners().get(0).getWordProposed());
        if (table.getIfNotFull()) {
            state = State.GAME_OVER;
        } else {
            this.refrshWord();
            state = State.STARTED;
            resetIsPlay();
        }

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
        if (bag.bagIsEmpty() || (state.equals(State.GAME_OVER)) || wordNotFound()) {
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
     * If towards the end of the game, the Bag and the table together can no
     * longer form a word, then stop the game
     */
    private boolean wordNotFound() {
        boolean notFound = false;
        if (this.bag.getMyBag().size() < 10 && this.bag.getMyBag().size() > 0) {
            List<Tile> myTiles = new ArrayList<>();
            myTiles.addAll(bag.getMyBag());
            myTiles.addAll(table.getMyTable());
            if (!findWordDico(myTiles)) {
                notFound = true;
            }
        }
        return notFound;
    }

    @Override
    public String findBestWord() {
        String ret = "";
        int max = 0;
        int maxScor = 0;

        for (String s : dictionnary.getAllWords()) {
            if (this.isWordPossible(table.getMyTable(), s)) {
                if (s.length() >= max && this.table.getScore(s) >= maxScor) {
                    max = s.length();
                    maxScor = this.table.getScore(s);
                    ret = s;
                }
            }
        }
        return ret;
    }

    /**
     * compares the size of the word propose by the player and returns the list
     * of the player who has the longest word
     *
     * @param playerOne first player
     * @param playerTwo second player
     * @return the list of the player who has the longest word
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
     * calculate the score of the players winning the round
     *
     * @param winner list player winner round
     */
    private void calculatScorWinner(List<Player> winner) {
        for (Player pp : winner) {
            pp.addScore(this.table.getScore(pp.getWordProposed()));
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
        return (count == 2);
    }

    /**
     * reset the isPLay attribute of each player to false
     */
    private void resetIsPlay() {
        for (Player pl : players) {
            pl.rsetIsPlay();
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

    /**
     * receives a list and checks if a dictionary word is found in the list
     *
     * @param list of the Tile
     * @return if find word in List
     */
    private boolean findWordDico(List<Tile> ll) {
        boolean find = false;
        for (String s : dictionnary.getAllWords()) {
            if (this.isWordPossible(ll, s)) {
                find = true;
            }
        }
        return find;
    }

    /**
     * returns a boolean that says if the proposed word exists in the List
     *
     * @param list
     * @param word proposed word
     * @return boolean word if exists
     */
    public boolean isWordPossible(List<Tile> list, String word) {
        if (word == null) {
            throw new IllegalArgumentException("word cannot be null");
        }
        char[] charWord = word.toCharArray();
        List<Character> copyTableCHar = new ArrayList();
        boolean okProfond = false;
        boolean okFacade = true;
        for (Tile tt : list) {
            copyTableCHar.add(tt.getLetter());
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

    public Table getTable(){
        return this.table;
    }
    public Bag getBag() {
        return this.bag;
    }

    public State getState() {
        return this.state;
    }
}
