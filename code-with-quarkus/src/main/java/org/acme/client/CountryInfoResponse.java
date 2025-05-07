package org.acme.client;

import java.util.List;

public class CountryInfoResponse {
    private String commonName;
    private String officialName;
    private String countryCode;
    private String region;
    private List<CountryInfoResponse> borders;

    public CountryInfoResponse(String commonName, String officialName, String countryCode, String region, List<CountryInfoResponse> borders) {
        this.commonName = commonName;
        this.officialName = officialName;
        this.countryCode = countryCode;
        this.region = region;
        this.borders = borders;
    }

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public String getOfficialName() {
        return officialName;
    }

    public void setOfficialName(String officialName) {
        this.officialName = officialName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public List<CountryInfoResponse> getBorders() {
        return borders;
    }

    public void setBorders(List<CountryInfoResponse> borders) {
        this.borders = borders;
    }
}
