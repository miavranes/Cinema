package org.acme.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Application;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.model.Movie;
import org.acme.repository.CinemaHallRepository;
import org.acme.repository.MovieRepository;

@Path("/movies/")
public class MovieResource {

    @Inject
    private MovieRepository movieRepository;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/addMovie")
    public Response createMovie(Movie movie) {
        Movie m = movieRepository.createMovie(movie);
        return Response.ok().entity(m).build();
    }
}
