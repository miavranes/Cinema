package org.acme.repository;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.acme.model.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Dependent
public class MovieRepository {

    @Inject
    private EntityManager em;

    @Transactional
    public MovieActors createMovieActors(MovieActors movieActors) {
        return em.merge(movieActors);
    }

    @Transactional
    public Movie createMovie(Movie movie) {
        return em.merge(movie);
    }

    public Movie findById(int id) {
        return em.find(Movie.class, id);
    }

    @Transactional
    public Movie updateMovie(Movie movie) {
        return em.merge(movie);
    }

}
