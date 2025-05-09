package org.acme.client;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(configKey = "weather-api")
@Path("/weather")
public interface WeatherClient {

    @GET
    @Path("/{city}")
    WeatherResponse getWeather(@PathParam("city") String city);


}
