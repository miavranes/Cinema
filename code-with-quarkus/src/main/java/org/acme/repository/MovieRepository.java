package org.acme.repository;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.acme.model.*;

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



}
