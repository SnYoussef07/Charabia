package g41385.charabia.view;

import g41385.charabia.model.Charabia;
import g41385.charabia.model.CharabiaGame;
import g41385.charabia.model.Player;
import g41385.charabia.model.Tile;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author 41385
 */
public class CharabiaView {

    private final Charabia charabiaGame;
    private final Scanner sc = new Scanner(System.in);

    public CharabiaView() throws IOException {
        charabiaGame = new CharabiaGame();
    }

    public String displayTile(Tile tile) {
        return "[" + tile.getChar() + "||" + tile.getScoring() + "]";
    }

    public String displayTable() {
        String str = "";
        System.out.println("                                                 "
                + "Il reste [" + charabiaGame.numberTiles() + "] Tuile Dans le Sac");
        str += "    -----------------------------------------------------------"
                + "----------------------------------------------"
                + "-------------" + '\n';
        for (Tile tile : this.charabiaGame.getListTile()) {
            str += "    :" + displayTile(tile) + ":";
        }
        str += '\n';
        str += "    ------------------------------------------------------------"
                + "----------------------------------------------"
                + "------------" + '\n';
        return str;
    }

    public void joinGame() {
        System.out.println("Entrer le nom du joueur 1");
        String p1 = sc.nextLine();
        System.out.println("Entrer le nom du joueur 2");
        String p2 = sc.nextLine();
        while (p2.equals(p1)) {
            System.out.println("Nom incorrect veuillez introduire un autre nom ");
            p2 = sc.nextLine();
        }
        System.out.println('\n');
        System.out.println("Initialisation des Joueurs");
        System.out.println("__________________________" + '\n');
        System.out.println("    Joueur [|" + charabiaGame.joinGame(p1).getName() + "|]");
        System.out.println("    Joueur [|" + charabiaGame.joinGame(p2).getName() + "|]");
        System.out.println("__________________________" + '\n');
    }

    public void displayPlay(boolean ok) {
        System.out.println(displayTable());
        System.out.println("                              "
                + "[_" + charabiaGame.getCurrentPlayer().getName()
                + "_] Proposer votre -Mot- ou -pass- pour passer votre tour");
        String p1Word;
        while (ok) {
            System.out.print("*** ");
            p1Word = sc.nextLine();
            if (charabiaGame.isPlay(p1Word)) {
                ok = false;
                charabiaGame.play(charabiaGame.getCurrentPlayer(), p1Word);
            } else {
                System.out.println("Mot introuvable dans le Dictionnaire"
                        + " OU dans la Table !!!");
            }
        }
        ok = true;
    }

    public void displayRoundOver(int countWin) {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
        System.out.println("                                            "
                + "     ______________________________" + '\n');
        System.out.println("                                            "
                + "     *** Joueur Gagnant Du Round ***");
        for (Player pp : charabiaGame.getRoundWinners()) {
            if (!"".equals(pp.getWordProposed())) {
                System.out.println("                                    "
                        + "             Nom : " + pp.getName());
                System.out.println("                                    "
                        + "             Scor : " + pp.getScore());
                System.out.println("                                    "
                        + "             ------------------------------");
                countWin++;
            }
        }
        if (countWin == 0) {
            System.out.println("                                        "
                    + "         ! Aucun Gagnant dans ce toure !");
        }
        System.out.println("                                            "
                + "     ______________________________" + '\n');
        for (int i = 0; i < 20; i++) {
            System.out.println();
        }
    }

    public void displayWinner() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
        System.out.println("                                            "
                + "     $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        System.out.println("                                            "
                + "     ______________________________" + '\n');
        System.out.println("                                            "
                + "     §§§§§ Les Gagnant §§§§§");
        for (Player pp : charabiaGame.getWinners()) {
            System.out.println("                                    "
                        + "             Nom : " + pp.getName());
                System.out.println("                                    "
                        + "             Scor : " + pp.getScore());
                System.out.println("                                    "
                        + "             ------------------------------");
        }
        System.out.println("                                            "
                + "     ______________________________" + '\n');
        System.out.println("                                            "
                + "     $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        for (int i = 0; i < 30; i++) {
            System.out.println();
        }
    }

    public void startGame() {
        boolean ok = true;
        int countWin = 0;
        while (!charabiaGame.isGameOver()) {
            charabiaGame.wordNotFound(); 
            if (charabiaGame.isRoundOver()) {
                countWin = 0;
                displayRoundOver(countWin);
                charabiaGame.nextRound();
            } else {
                displayPlay(ok);
            }
        }
        displayWinner();
    }

    public void play() {
        joinGame();
        startGame();  
    }

    public static void main(String[] args) throws IOException {
        CharabiaView view = new CharabiaView();
        view.play();
    }
}
