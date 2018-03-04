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
        Player pp = new Player("Youssef");

        /*System.out.println(ch.getTable());                      TEST IFEXIST
        System.out.println("Entrer un mot en MAJISCUL");
        String str = sc.nextLine();
        System.out.println("Resultat ->>>");
        System.out.println(ch.getTable().ifExists(str));*/
        
        System.out.println(ch.getTable());
        System.out.println("Entrer un mot en MAJISCUL");
        String str = sc.nextLine();
        System.out.println("Resultat ->>>");
        ch.getTable().refreshTable(str);
        System.out.println(ch.getTable());
    }
}
