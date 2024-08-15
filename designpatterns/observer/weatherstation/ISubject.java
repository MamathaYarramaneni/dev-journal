package com.designpatterns.observer.weatherstation;

public interface ISubject {
    void registerObserver(IObserver o);
    void unregisterObserver(IObserver o);
    void notifyObservers();
}