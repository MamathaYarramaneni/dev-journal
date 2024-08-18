package designpatterns.observer.weatherstation;

import java.util.*;

public class WeatherDataSubject implements ISubject {
    private int temperature;
    private int humidity;
    private List<IObserver> observers;

    public WeatherDataSubject() {
        observers = new ArrayList<IObserver>();
    }

    public void registerObserver(IObserver o) {
        observers.add(o);
    }

    public void unregisterObserver(IObserver o) {
        if(observers.indexOf(o) >= 0) observers.remove(o);
    }

    public void notifyObservers() {
        for(IObserver o: observers) {
            o.update(temperature, humidity);
        }
    }

    public void setData(int temperature, int humidity) {
        this.temperature = temperature;
        this.humidity = humidity;
        notifyObservers();
    }
}