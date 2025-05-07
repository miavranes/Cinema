package org.acme.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class CountryInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "country_info_seq")

    private int id;
    private String commonName;
    private String officialName;
    private String countryCode;
    private String region;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_country_code")
    private List<CountryInfo> borders = new ArrayList<>();

    public CountryInfo(){}
    public CountryInfo(String commonName, String officialName, String countryCode, String region, List<CountryInfo> borders) {
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

    public List<CountryInfo> getBorders() {
        return borders;
    }

    public void setBorders(List<CountryInfo> borders) {
        this.borders = borders;
    }
}
