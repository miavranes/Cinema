package org.acme.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "movie_seq")
    private int id;
    private String title;
    private int durationInMinutes;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Actor> actors;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "director_id", referencedColumnName = "id")
    private Director director;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Genre> genres;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Projection> projections;

    public Movie(){}
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

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", durationInMinutes=" + durationInMinutes +
                ", actors=" + actors +
                ", director=" + director +
                ", genres=" + genres +
                ", projections=" + projections +
                '}';
    }
}
