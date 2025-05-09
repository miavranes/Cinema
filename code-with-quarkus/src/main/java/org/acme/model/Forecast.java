package org.acme.model;

import jakarta.persistence.*;

@Entity
public class Forecast {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "forecast_seq")
    private int id;
    private int day;
    private String temperature;
    private String wind;
    @ManyToOne
    @JoinColumn(name = "weather_id")
    private WeatherEntity weatherEntity;

    public Forecast(int id, int day, String temperature, String wind) {
        this.id = id;
        this.day = day;
        this.temperature = temperature;
        this.wind = wind;
    }

    public Forecast(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getWind() {
        return wind;
    }

    public void setWind(String wind) {
        this.wind = wind;
    }
}
