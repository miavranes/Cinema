package org.acme.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.client.WeatherClient;
import org.acme.model.Forecast;
import org.acme.model.HolidayType;
import org.acme.model.WeatherEntity;
import org.acme.repository.WeatherRepository;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/weather/")
public class WeatherResource {

    @RestClient
    private WeatherClient weatherClient;

    @Inject
    private WeatherRepository weatherRepository;


    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("getWeather/{city}")
    public Response getWeather(@PathParam("city") String city) {

        var forecast = weatherClient.getWeather(city);


        return Response.ok().entity(forecast).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("saveWeather/{city}")
    public Response saveWeather(@PathParam("city") String city) {

        boolean exists = weatherRepository.checkCityName(city);
        if(exists){
            return Response.status(Response.Status.CONFLICT)
                    .entity("Vremenska prognoza za grad '" + city + "' vec postoji")
                    .build();
        }

        var weather = weatherClient.getWeather(city);
        WeatherEntity weatherEntity = new WeatherEntity();
        weatherEntity.setCityName(city);
        weatherEntity.setDescription(weather.getDescription());
        weatherEntity.setTemperature(weather.getTemperature());
        weatherEntity.setWind(weather.getWind());

        for(var weatherForecast : weather.getForecast()){
            Forecast forecast = new Forecast();
            forecast.setDay(weatherForecast.getDay());
            forecast.setTemperature(weatherForecast.getTemperature());
            forecast.setWind(weatherForecast.getWind());
            weatherEntity.getForecast().add(forecast);
        }
        weatherRepository.create(weatherEntity);
        return Response.ok().entity(weatherEntity).build();
    }

}
