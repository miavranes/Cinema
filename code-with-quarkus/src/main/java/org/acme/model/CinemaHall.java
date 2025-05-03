package org.acme.model;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@NamedQueries({
        @NamedQuery(name = CinemaHall.GET_ALL_CINEMAHALLS, query = "SELECT ch FROM CinemaHall ch"),
        @NamedQuery(name = CinemaHall.GET_CINEMAHALL_BY_NAME, query = "SELECT ch FROM CinemaHall ch WHERE ch.name = :name")
})

public class CinemaHall {

    public static final String GET_ALL_CINEMAHALLS = "CinemaHall.getAllCinemaHalls";
    public static final String GET_CINEMAHALL_BY_NAME = "CinemaHall.getCinemaHallByName";
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cinema_hall_seq")
    private int id;
    private String name;
    private int noOfSeats;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Projection> projections;

    public CinemaHall(){}
    public CinemaHall(int id, String name, int noOfSeats) {
        this.id = id;
        this.name = name;
        this.noOfSeats = noOfSeats;
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

    public Set<Projection> getProjections() {
        return projections;
    }

    public void setProjections(Set<Projection> projections) {
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
