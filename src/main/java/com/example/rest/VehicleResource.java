package com.example.rest;

import com.example.model.Vehicle;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

@Path("/vehicles")
public class VehicleResource {
    private static final Logger logger = LoggerFactory.getLogger(VehicleResource.class);
    private static List<Vehicle> vehicles = new ArrayList<>();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getVehicles() {
        logger.info("Получен запрос на получение списка транспортных средств");
        logger.debug("Текущее количество транспортных средств: {}", vehicles.size());
        return Response.ok(vehicles).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
        logger.debug("Добавлено новое транспортное средство: {}", vehicle);
        logger.info("Общее количество транспортных средств после добавления: {}", vehicles.size());
        return Response.status(Response.Status.CREATED).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteVehicle(@PathParam("id") int id) {
        if (id >= 0 && id < vehicles.size()) {
            Vehicle removed = vehicles.remove(id);
            logger.warn("Удалено транспортное средство: {}", removed);
            return Response.ok().build();
        } else {
            logger.error("Попытка удаления транспортного средства с недопустимым индексом: {}", id);
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
