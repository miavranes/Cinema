package org.acme.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.client.CountryClient;
import org.acme.client.NextPublicHolidayResponse;
import org.acme.model.HolidayType;
import org.acme.model.MovieActors;
import org.acme.model.PublicHoliday;
import org.acme.repository.MovieRepository;
import org.acme.repository.PublicHolidayRepository;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/country/")
public class CountryResource {

    @RestClient
    private CountryClient countryClient;

    @Inject
    private PublicHolidayRepository publicHolidayRepository;

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("getAvailableCountries")
    public Response getAvailableCountries() {

        var availableCountries = countryClient.getAvailableCountries();

        return Response.ok().entity(availableCountries).build();
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("getNextPublicHolidays/{countryCode}")
    public Response getNextPublicHolidays(@PathParam("countryCode") String countryCode) {

        var nextPublicHolidays = countryClient.getNextPublicHolidays(countryCode);

        return Response.ok().entity(nextPublicHolidays).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("saveNextPublicHolidays/{countryCode}")
    public Response saveNextPublicHolidays(@PathParam("countryCode") String countryCode) {

        var nextPublicHolidays = countryClient.getNextPublicHolidays(countryCode);

        for (NextPublicHolidayResponse holidayResponse : nextPublicHolidays) {

            boolean exists = publicHolidayRepository.existsByDateAndName(holidayResponse.getDate(), holidayResponse.getName());
            if(exists)
                continue;

            PublicHoliday holiday = new PublicHoliday();
            holiday.setCountryCode(holidayResponse.getCountryCode());
            holiday.setDate(holidayResponse.getDate());
            holiday.setFixed(holidayResponse.isFixed());
            holiday.setGlobal(holiday.isGlobal());
            holiday.setName(holidayResponse.getName());
            holiday.setLaunchYear(holidayResponse.getLaunchYear());
            holiday.setLocalName(holidayResponse.getLocalName());
            for(String type: holidayResponse.getTypes()){
                var holidayType = new HolidayType();
                holidayType.setName(type);
                holidayType.setHoliday(holiday);
                holiday.getTypes().add(holidayType);
            }
            publicHolidayRepository.create(holiday);
        }

        return Response.ok().build();
    }
}
