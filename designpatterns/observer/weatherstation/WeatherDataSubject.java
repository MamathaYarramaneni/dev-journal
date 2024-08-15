package com.designpatterns.observer.weatherstation;

import java.util.*;

public class WeatherDataSubject implements ISubject {
    private int temperature;
    private List<IObserver> observers;

    WeatherDataSubject() {
        observers = new List();
    }

    void registerObserver(IObserver o) {
        observers.add(o);
    }

    void unregisterObserver(IObserver o) {
        if(observers.indexOf(o) >= 0) observers.remove(o);
    }

    void notifyObservers() {
        for(IObserver o: observers) {
            o.update(temperature);
        }
    }

    void setTemperature(int temperature) {
        this.temperature = temperature;
        notifyObservers();
    }
}