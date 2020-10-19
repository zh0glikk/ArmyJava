package Army.Observer;

import java.util.HashSet;
import java.util.Set;

public class Observable {
    private Set<Observer> observers;

    public Observable() {
        this.observers = new HashSet<Observer>();
    }

    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    public void removeObserbver(Observer observer) {
        this.observers.remove(observer);
    }

    public void sendMessage() {
        if (!observers.isEmpty()) {
            for (Observer obs : observers) {
                obs.recieveMessage();
            }
        }
    }
}
