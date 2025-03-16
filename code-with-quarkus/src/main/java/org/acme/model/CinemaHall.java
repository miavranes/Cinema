package org.acme.model;

import java.util.List;

public class CinemaHall {

    private int id;
    private String name;
    private int noOfSeats;
    private List<Projection> projections;


    public CinemaHall(int id, String name, int noOfSeats, List<Projection> projections) {
        this.id = id;
        this.name = name;
        this.noOfSeats = noOfSeats;
        this.projections = projections;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNoOfSeats() {
        return noOfSeats;
    }

    public void setNoOfSeats(int noOfSeats) {
        this.noOfSeats = noOfSeats;
    }

    public List<Projection> getProjections() {
        return projections;
    }

    public void setProjections(List<Projection> projections) {
        this.projections = projections;
    }
}
