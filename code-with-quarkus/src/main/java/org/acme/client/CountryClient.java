package org.acme.client;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.List;

@RegisterRestClient(configKey = "country-api")
public interface CountryClient {

    @GET
    @Path("/AvailableCountries")
    List<AvailableCountriesResponse> getAvailableCountries();

    @GET
    @Path("/NextPublicHolidays/{countryCode}")
    List<NextPublicHolidayResponse> getNextPublicHolidays(@PathParam("countryCode") String countryCode);

    @GET
    @Path("/CountryInfo/{countryCode}")
    CountryInfoResponse getCountryInfo(@PathParam("countryCode") String countryCode);

    @GET
    @Path("/NextPublicHolidaysWorldwide")
    List<WorldwideHolidayResponse> getWorldwideHolidays();
}
