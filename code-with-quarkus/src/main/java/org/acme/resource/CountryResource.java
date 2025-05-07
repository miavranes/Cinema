package org.acme.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.client.CountryClient;
import org.acme.client.CountryInfoResponse;
import org.acme.client.NextPublicHolidayResponse;
import org.acme.client.WorldwideHolidayResponse;
import org.acme.model.CinemaHall;
import org.acme.model.CountryInfo;
import org.acme.model.HolidayType;
import org.acme.model.PublicHoliday;
import org.acme.repository.CountryRepository;
import org.acme.repository.PublicHolidayRepository;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.List;

@Path("/country/")
public class CountryResource {

    @RestClient
    private CountryClient countryClient;

    @Inject
    private PublicHolidayRepository publicHolidayRepository;

    @Inject
    private CountryRepository countryRepository;



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

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("getCountryInfo/{countryCode}")
    public Response getCountryInfo(@PathParam("countryCode") String countryCode) {

        var info = countryClient.getCountryInfo(countryCode);

        return Response.ok().entity(info).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("saveCountryInfo/{countryCode}")
    public Response saveCountryInfo(@PathParam("countryCode") String countryCode) {
        CountryInfoResponse response = countryClient.getCountryInfo(countryCode);

        CountryInfo countryInfo = new CountryInfo();
        countryInfo.setCommonName(response.getCommonName());
        countryInfo.setCountryCode(response.getCountryCode());
        countryInfo.setRegion(response.getRegion());
        countryInfo.setOfficialName(response.getOfficialName());

        if (response.getBorders() != null){
            for (CountryInfoResponse borderResponse : response.getBorders()){
                CountryInfo border = new CountryInfo();
                border.setCommonName(borderResponse.getCommonName());
                border.setCountryCode(borderResponse.getCountryCode());
                border.setRegion(borderResponse.getRegion());
                border.setOfficialName(borderResponse.getOfficialName());

                countryInfo.getBorders().add(border);
            }
        }

        countryRepository.create(countryInfo);

        return Response.ok().build();
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("getWorldsWideHolidays")
    public Response getWorldwideHolidays(){
        var holidays = countryClient.getWorldwideHolidays();

        return Response.ok().entity(holidays).build();
    }
}
