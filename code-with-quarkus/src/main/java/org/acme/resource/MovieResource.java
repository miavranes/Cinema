package org.acme.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.model.*;
import org.acme.repository.MovieRepository;

import java.util.ArrayList;

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


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/addMovie")
    public Response createMovie(Movie movie) {
        Movie m = movieRepository.createMovie(movie);
        return Response.ok().entity(m).build();
    }



}
