package g41385.charabia.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author 41385
 */
public class Dictionnary {
    
    private List <String> myDico;
    private File file;
    private Scanner scan;

    public Dictionnary() throws FileNotFoundException {
        this.myDico = new ArrayList();
        this.file = new File("Dictionary.txt");
        
        this.scan = new Scanner(file);
        this.scan.useDelimiter("\n");
        
        while (scan.hasNext()) {
            this.myDico.add(scan.nextLine());     
        }
    }

    public List<String> getMyDico() { ///Mauvais faire une copie a envoyé 
        return myDico;
    }
    
    
    
    
    
}
