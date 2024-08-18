package designpatterns.observer.weatherstation;

public class HumidityDisplay implements IObserver, IDisplay {
    private int humidity;
    private WeatherDataSubject weatherDataSubject;

    public HumidityDisplay(WeatherDataSubject weatherDataSubject) {
        this.weatherDataSubject = weatherDataSubject;
        weatherDataSubject.registerObserver(this);
    }

    @Override
    public void update(int temperature, int humidity) {
        this.humidity = humidity;
    }

    @Override
    public void display() {
        System.out.println("current humidity: " + humidity);
    }
}