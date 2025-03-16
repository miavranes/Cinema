package org.acme.model;

import java.util.List;

public class Projection {

    private int id;
    private String date;
    private Movie movie;
    private List<CinemaHall> cinemaHalls;


    public Projection(int id, String date, Movie movie, List<CinemaHall> cinemaHalls) {
        this.id = id;
        this.date = date;
        this.movie = movie;
        this.cinemaHalls = cinemaHalls;
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

    public List<CinemaHall> getCinemaHalls() {
        return cinemaHalls;
    }

    public void setCinemaHalls(List<CinemaHall> cinemaHalls) {
        this.cinemaHalls = cinemaHalls;
    }
}
