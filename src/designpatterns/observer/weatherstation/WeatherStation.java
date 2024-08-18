package designpatterns.observer.weatherstation;

import java.util.*;

public class WeatherStation {
    public static void main(String[] args) {
        WeatherDataSubject weatherDataSubject = new WeatherDataSubject();
        TemperatureDisplay temperatureDisplay = new TemperatureDisplay(weatherDataSubject);
        HumidityDisplay humidityDisplay = new HumidityDisplay(weatherDataSubject);

        weatherDataSubject.setData(69, 70);
        temperatureDisplay.display();
        humidityDisplay.display();
    }
}