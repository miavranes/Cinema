package org.acme.restclient;

import jakarta.persistence.*;
import org.acme.model.Actor;
import org.acme.model.Movie;

@Entity
public class MovieActors {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "movieactors_seq")
    private int id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public Movie movie;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public Actor actor;

    public MovieActors() {
        super();
    }

    public MovieActors(int id, Movie movie, Actor actor) {
        this.id = id;
        this.movie = movie;
        this.actor = actor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }
}
