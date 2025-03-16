package org.acme.model;

import java.util.List;

public class Movie {

    private int id;
    private String title;
    private int durationInMinutes;
    private List<Actor> actors;
    private Director director;
    private List<Genre> genres;
    private List<Projection> projections;

    public Movie(int id, String title, int durationInMinutes, List<Actor> actors, Director director, List<Genre> genres, List<Projection> projections) {
        this.id = id;
        this.title = title;
        this.durationInMinutes = durationInMinutes;
        this.actors = actors;
        this.director = director;
        this.genres = genres;
        this.projections = projections;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public List<Projection> getProjections() {
        return projections;
    }

    public void setProjections(List<Projection> projections) {
        this.projections = projections;
    }
}
