package org.acme.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.model.CinemaHall;
import org.acme.repository.CinemaHallRepository;
import java.util.List;

@Path("/cinema_hall/")

public class CinemaHallResource {

    @Inject
    private CinemaHallRepository cinemaHallRepository;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/addCinemaHall")
    public Response createCinemaHall(CinemaHall hall) {
        CinemaHall ch = cinemaHallRepository.createCinemaHall(hall);
        return Response.ok().entity(ch).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getAllCinemaHalls")
    public Response getAllCinemaHalls () {
        List<CinemaHall> halls = cinemaHallRepository.getAllCinemaHalls();
        return Response.ok().entity(halls).build();
    }


}
