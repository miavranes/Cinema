package org.acme.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "actor_seq")
    private int id;
    private String name;
    @ManyToMany(mappedBy = "actors",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Movie> movies;

    public Actor(){}
    public Actor(int id, String name) {
        this.id = id;
        this.name = name;
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

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", movies=" + movies +
                '}';
    }
}
