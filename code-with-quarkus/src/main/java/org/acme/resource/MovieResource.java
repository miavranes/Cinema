package org.acme.resource;

import jakarta.inject.Inject;
import org.acme.service.FileService;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.model.*;
import org.acme.repository.MovieRepository;
import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Path("/movies/")
public class MovieResource {

    @Inject
    private MovieRepository movieRepository;

    @Inject
    FileService fileService;

    @ConfigProperty(name = "file.upload.directory", defaultValue = "uploads/")
    String uploadDirectory;


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("createMovieActors")
    public Response getTime(MovieActors movieActors) {

        MovieActors movieActors1 = movieRepository.createMovieActors(movieActors);

        return Response.ok().entity(movieActors1).build();
    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/addMovie")
    public Response createMovie(Movie movie) {
        Movie m = movieRepository.createMovie(movie);
        return Response.ok().entity(m).build();
    }

    @POST
    @Path("/uploadFile")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response uploadFile(@QueryParam("movieId") int movieId, @FormParam("fileName") String fileName, @FormParam("file") InputStream fileInputStream) {

        try {
            Movie movie = movieRepository.findById(movieId);
            if (movie == null) {
                return Response.status(Response.Status.NOT_FOUND).entity("Film sa ID " + movieId + " nije pronadjen").build();
            }

            File uploadDir = new File(uploadDirectory);
            if (!uploadDir.exists()) {
                uploadDir.mkdirs();
            }

            String filePath = uploadDirectory + fileName;

            movie.setFilePath(filePath);
            movieRepository.updateMovie(movie);

            return Response.ok().entity("Fajl uspjesno sacuvan: " + fileName).build();

        } catch (Exception e) {
            return Response.ok().entity("Greska pri cuvanju fajla: " + e.getMessage()).build();
        }
    }
}