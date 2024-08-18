package designpatterns.observer.weatherstation;

public class TemperatureDisplay implements IObserver, IDisplay {
    private int temperature;
    private WeatherDataSubject weatherDataSubject;

    public TemperatureDisplay(WeatherDataSubject weatherDataSubject) {
        this.weatherDataSubject = weatherDataSubject;
        weatherDataSubject.registerObserver(this);
    }

    @Override
    public void update(int temperature, int humidity) {
        this.temperature = temperature;
    }

    @Override
    public void display() {
        System.out.println("current temperature: " + temperature);
    }
}