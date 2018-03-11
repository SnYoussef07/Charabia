package g41385.charabia.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * game dictionary
 *
 * @author 41385
 */
class Dictionary {

    private final List<String> myDico;
    private final File file = new File("Dictionary");
    private String path = file.getAbsolutePath();
    private BufferedReader br;

    Dictionary() throws FileNotFoundException, IOException {
        this.myDico = new ArrayList();
        initDictionary();
    }

    /**
     * initialize the dictionary and add it to the list
     *
     * @throws FileNotFoundException
     * @throws IOException
     */
    private void initDictionary() throws FileNotFoundException, IOException {
        try {
            br = new BufferedReader(new FileReader(path += ".txt"));
            String line;
            while ((line = br.readLine()) != null) {
                myDico.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * return a boolean if the word is find in the dictionary
     *
     * @param the word to find
     * @return if he finds it
     */
    boolean findWord(String word) {
        if (word == null) {
            throw new IllegalArgumentException("word cannot be null");
        }
        boolean ok = false;
        for (String s : myDico) {
            if (word.equals(s)) {
                ok = true;
                break;
            }
        }
        return ok;
    }

    /**
     * Return myDico
     *
     * @return List<String copy of the Dico
     */
    List<String> getMyDico() {
        List<String> copyDico = this.myDico;
        return copyDico;
    }
}
