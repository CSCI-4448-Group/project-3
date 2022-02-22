// Subject interface has three methods to register observers, remove an observer, and notify an observer if an announcement was sent

public interface Subject {
    public void registerObserver(Observer o);
    public void removeObserver();
    public void notifyObservers(String announcement);
}
