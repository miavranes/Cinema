package org.acme.repository;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.acme.model.Movie;

@Dependent
public class MovieRepository {

    @Inject
    private EntityManager em;

    @Transactional
    public Movie createMovie(Movie movie) {
        return em.merge(movie);
    }

}
