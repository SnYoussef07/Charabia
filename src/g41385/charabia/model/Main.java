package g41385.charabia.model;

import java.io.FileNotFoundException;
import java.io.IOException;
import static java.lang.System.in;
import java.util.Scanner;

/**
 *
 * @author snsmaug
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner sc = new Scanner(System.in);

        /*Dictionary dc = new Dictionary();
        System.out.println(dc);*/
        CharabiaGame ch = new CharabiaGame();

        /*System.out.println(ch.getTable());                      TEST IFEXIST
        System.out.println("Entrer un mot en MAJISCUL");
        String str = sc.nextLine();
        System.out.println("Resultat ->>>");
        System.out.println(ch.getTable().ifExists(str));*/
 /*while (true) {
            if (ch.isGameOver()) {
                System.out.println("FIN DE JEUX PAS ASSER DE JETON");
            } else {
                System.out.println(ch.getTiles());
                System.out.println("Entrer un mot en MAJISCUL");
                String str = sc.nextLine();
                System.out.println("Resultat ->>>");
                ch.getTiles().refreshTable(str);
                System.out.println(ch.getTiles());
                System.out.println("Il rest " + ch.getBag().getMyBag().size() + " Dans le sac");
            }
        }*/
 /*System.out.println(ch.getTiles());                        Test Refrsh                
        System.out.println("Entrer un mot en MAJISCUL");
        String str = sc.nextLine();
        System.out.println("Resultat ->>>");
        ch.getTiles().refreshTable(str);
        System.out.println(ch.getTiles());*/
        System.out.println("Entreé le nom du joueur 1");
        String p1 = sc.nextLine();
        System.out.println("Entré le nom du joueur 2");
        String p2 = sc.nextLine();
        System.out.println("Joueur " + ch.joinGame(p1).getName() + " Ajouter ");
        System.out.println("Joueur " + ch.joinGame(p2).getName() + " Ajouter ");

        System.out.println("initialisation de la table de jeux");

        while (!ch.isGameOver()) {
            System.out.println(ch.getTiles());
            if (ch.isRoundOver()) {
                for (Player pp : ch.getRoundWinners()) {
                    System.out.println("Les joueur gagant sont " + pp.getName());
                }
                ch.nextRound();
            } else {
                System.out.println("Joueur " + ch.getCurrentPlayer().getName() + " Proposer votre mot");
                String p1Word = sc.nextLine();
                ch.play(ch.getCurrentPlayer(), p1Word); // ajout de current
                System.out.println("---------------------------------------------------------");
            }
        }
    }
}
