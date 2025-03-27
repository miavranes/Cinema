package org.acme.model;

import jakarta.persistence.*;

import java.util.List;
@Entity
public class CinemaHall {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cinema_hall_seq")
    private int id;
    private String name;
    private int noOfSeats;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Projection> projections;

    public CinemaHall(){}
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

    @Override
    public String toString() {
        return "CinemaHall{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", noOfSeats=" + noOfSeats +
                ", projections=" + projections +
                '}';
    }
}
