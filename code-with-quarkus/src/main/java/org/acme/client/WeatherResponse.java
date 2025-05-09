package org.acme.client;

import org.acme.model.Forecast;

import java.util.List;

public class WeatherResponse {

     private String cityName;
     private String temperature;
     private String wind;
     private String description;
     private List<Forecast> forecast;

     public WeatherResponse(String cityName, String temperature, String wind, String description, List<Forecast> forecast) {
         this.cityName = cityName;
         this.temperature = temperature;
         this.wind = wind;
         this.description = description;
         this.forecast = forecast;
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

     public String getDescription() {
          return description;
     }

     public void setDescription(String description) {
          this.description = description;
     }

     public List<Forecast> getForecast() {
          return forecast;
     }

     public void setForecast(List<Forecast> forecast) {
          this.forecast = forecast;
     }


     public String getCityName() {
          return cityName;
     }

     public void setCityName(String cityName) {
          this.cityName = cityName;
     }
}
