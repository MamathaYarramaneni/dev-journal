package designpatterns.observer.weatherstation;

public interface ISubject {
    public void registerObserver(IObserver o);
    public void unregisterObserver(IObserver o);
    public void notifyObservers();
}