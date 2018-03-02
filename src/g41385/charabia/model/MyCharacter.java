package g41385.charabia.model;
/**
 * represents a character and its appearance number
 * @author g41385
 */
class MyCharacter {
    
    private final char myLetter;
    private int multip;
    /**
     * COnstruct class MyCharacter
     * @param myLetter char of the class
     */
    MyCharacter(char myLetter) {
        this.myLetter = myLetter;
        init();
    }
    
    /**
     * initializes the number of repetitions according to the letter
     */
    private void init(){
        switch(myLetter){
            case 'A' : multip=9;break;
            case 'B' : multip=2;break;
            case 'C' : multip=2;break;
            case 'D' : multip=3;break;
            case 'E' : multip=15;break;
            case 'F' : multip=2;break;
            case 'G' : multip=2;break;
            case 'H' : multip=2;break;
            case 'I' : multip=8;break;
            case 'J' : multip=1;break;
            case 'K' : multip=1;break;
            case 'L' : multip=5;break;
            case 'M' : multip=3;break;
            case 'N' : multip=6;break;
            case 'O' : multip=6;break;
            case 'P' : multip=2;break;
            case 'Q' : multip=1;break;
            case 'R' : multip=6;break;
            case 'S' : multip=6;break;
            case 'T' : multip=6;break;
            case 'U' : multip=6;break;
            case 'V' : multip=2;break;
            case 'W' : multip=1;break;
            case 'X' : multip=1;break;
            case 'Y' : multip=1;break;
            case 'Z' : multip=1;break;  
        }
    }
    /**
     * return myLetter
     * @return char 
     */
    public char getMyLetter() {return myLetter;}
    /**
     * Return multip
     * @return int 
     */
    public int getMultip() {return multip;}
}
