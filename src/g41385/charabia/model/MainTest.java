package g41385.charabia.model;

import java.io.FileNotFoundException;
import java.io.IOException;
import static java.lang.System.in;
import java.util.Scanner;

/**
 *
 * @author snsmaug
 */
public class MainTest {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner sc = new Scanner(System.in);

        CharabiaGame ch = new CharabiaGame();

        /*System.out.println(ch.getTiles());                        //IFiXIST           
        System.out.println("Entrer un mot en MAJISCUL");
        String str = sc.nextLine();
        System.out.println("Resultat ->>>");
        System.out.println(ch.getTiles().ifExists(str));*/
        //System.out.println(ch.getTiles());   
        System.out.println("Entreé le nom du joueur 1");
        String p1 = sc.nextLine();
        System.out.println("Entré le nom du joueur 2");
        String p2 = sc.nextLine();
        System.out.println("Joueur " + ch.joinGame(p1).getName() + " Ajouter ");
        System.out.println("Joueur " + ch.joinGame(p2).getName() + " Ajouter ");

        System.out.println("initialisation de la table de jeux");
        boolean ok=true;
        while (!ch.isGameOver()) {
            System.out.println(ch.getTiles());
            if (ch.isRoundOver()) {

                for (Player pp : ch.getRoundWinners()) {
                    if (pp.getWordProposed() != "") {
                        System.out.println("Les joueur gagant sont " + pp.getName());
                        System.out.println("Avec un score de " + pp.getScore());
                    } else {
                        System.out.println("Aucun Gagnat dans ce toure ci !!!!!!!!!!!!");
                    }
                }

                ch.nextRound();
            } else {
                System.out.println("Joueur " + ch.getCurrentPlayer().getName() + " Proposer votre mot ou TAPER pass POUR passer votre toure");
                System.out.println("Le meilleur mot est === " + ch.recherchTest());
                while(ok){
                    String p1Word = sc.nextLine();
                    if(ch.isPlay(p1Word)){
                       ok = false; 
                       ch.play(ch.getCurrentPlayer(), p1Word); 
                    }else{
                        System.out.println("Mot introuvable dans le dicttionnaire OU dans la table");
                    }
                }
                ok=true;
                System.out.println("---------------------------------------------------------");
            }
            System.out.println("IL REST " + ch.numberTiles() + " Dans le sac");
        }
        System.out.println("LES GAGANT SONT :");
        for (Player pp : ch.getWinners()) {
            System.out.println(pp.getName());
        }

    }
}
