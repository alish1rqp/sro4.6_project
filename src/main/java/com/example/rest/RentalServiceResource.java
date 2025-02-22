package com.example.rest;

import com.example.model.RentalService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/rentals")
public class RentalServiceResource {
    private static List<RentalService> rentals = new ArrayList<>();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRentals() {
        return Response.ok(rentals).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addRental(RentalService rental) {
        rentals.add(rental);
        return Response.status(Response.Status.CREATED).build();
    }
}
