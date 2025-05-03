package org.acme.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@NamedQuery(name = Projection.GET_PROJECTIONS_FOR_CINEMAHALL, query = "SELECT p FROM Projection p WHERE p.cinemaHall.id = :id")
public class Projection {

    public static final String GET_PROJECTIONS_FOR_CINEMAHALL = "Projection.getProjectionsForCinemaHall";
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "projection_seq")
    private int id;
    private String date;
    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;
    @ManyToOne
    @JoinColumn(name = "cinema_hall_id")
    private CinemaHall cinemaHall;

    public Projection(){}
    public Projection(int id, String date, Movie movie, CinemaHall cinemaHall) {
        this.id = id;
        this.date = date;
        this.movie = movie;
        this.cinemaHall = cinemaHall;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public CinemaHall getCinemaHall() {
        return cinemaHall;
    }

    public void setCinemaHall(CinemaHall cinemaHall) {
        this.cinemaHall = cinemaHall;
    }

    @Override
    public String toString() {
        return "Projection{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", movie=" + movie +
                ", cinemaHall=" + cinemaHall +
                '}';
    }
}
