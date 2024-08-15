package com.designpatterns.observer.weatherstation;

public class TemperatureDisplay implements IObserver, IDisplay {
    int temperature;

    void update(int temperature) {
        this.temperature = temperature;
    }

    String display() {
        return "temperature: " + temperature;
    }
}