package g41385.charabia.observer;

/**
 *
 * @author G41385
 */
public interface Observable {
    
    public void registerObserver(Observer obs);

    public void removeObserver(Observer obs);

    public void notifyObservers();
}
