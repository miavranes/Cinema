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
import org.acme.restclient.MovieActors;

@Path("/movies/")
public class MovieResource {

    @Inject
    private MovieRepository movieRepository;


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("createMovieActors")
    public Response getTime(MovieActors movieActors) {

        MovieActors movieActors1 =  movieRepository.createMovieActors(movieActors);

        return Response.ok().entity(movieActors1).build();
    }
}
