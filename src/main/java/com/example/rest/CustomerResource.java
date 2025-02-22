package com.example.rest;

import com.example.model.Customer;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/customers")
public class CustomerResource {
    private static List<Customer> customers = new ArrayList<>();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCustomers() {
        return Response.ok(customers).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addCustomer(Customer customer) {
        customers.add(customer);
        return Response.status(Response.Status.CREATED).build();
    }
}
