/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g41385.charabia.view;

import g41385.charabia.model.Charabia;
import g41385.charabia.model.CharabiaGame;
import g41385.charabia.model.Tile;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author snsmaug
 */
public class CharabiaView {

    private Charabia charabiaGame;
    private Scanner sc = new Scanner(System.in);

    public CharabiaView() throws IOException {
        charabiaGame = new CharabiaGame();
    }

    public String displayTile(Tile tile) {
        return "[" + tile.getChar() + "||" + tile.getScoring() + "]";
    }

    public String displayTable() {
        String str = "";
        for (Tile tile : this.charabiaGame.getListTile()) {
            str += " " + displayTile(tile);
        }
        str += '\n';
        str += "--------------------------------------------------------------------------------" + '\n';
        return str;
    }

    public void joinGame() {
        System.out.println("Entreé le nom du joueur 1");
        String p1 = sc.nextLine();
        System.out.println("Entré le nom du joueur 2");
        String p2 = sc.nextLine();

        while (p2.equals(p1)) {
            System.out.println("Nom incorect r'eintroduisser un autre nom");
            p2 = sc.nextLine();
        }
        System.out.println("Initialisation des Joueurs"+'\n');
        System.out.println("__________________________"+'\n');
        System.out.println("Joueur [|" + charabiaGame.joinGame(p1).getName() + "|]");
        System.out.println("Joueur [|" + charabiaGame.joinGame(p2).getName() + "|]");
    }

    public void play() {
        joinGame();
    }

    public static void main(String[] args) throws IOException {
        CharabiaView view = new CharabiaView();
        view.play();

    }
}
