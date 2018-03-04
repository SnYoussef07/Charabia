package g41385.charabia.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 41385
 */
public class Dictionary {

    private List<String> myDico;
    File file = new File("Dictionary");

    public Dictionary() throws FileNotFoundException, IOException {
        this.myDico = new ArrayList();
       
        
        String path = file.getAbsolutePath();
        BufferedReader br = new BufferedReader(new FileReader(path += ".txt"));
        String line;
        while ((line = br.readLine()) != null) {
            myDico.add(br.readLine());
        }
        br.close();

    }
    
    public boolean findWord(String word){
        boolean ok = false;
        for(String s : myDico){
            if(word.equals(s)){
                ok = true;
            }
        }
        return ok;
    }

    @Override
    public String toString() {
        String ss = null;
        for(String s : myDico){
            ss = ss + s + "\n";
        }
        return ss;
    }

    
    public List<String> getMyDico() { ///Mauvais faire une copie a envoyé 
        return myDico;
    }

}
