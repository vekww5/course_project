package ru.rgatu.resource;

import ru.rgatu.pojo.Place;
import ru.rgatu.service.PlaceService;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/places")
public class PlaceResource {

    @Inject
    PlaceService ps;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getPlaces")
    @RolesAllowed({"watchP"})
    public Response getPlaces(){
        return Response.ok(ps.getPlaces()).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id_place}")
    public Response getPlaceById(@PathParam("id_place") Long id_place){
        return Response.ok(ps.getPlaceById(id_place)).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/insertPlace")
    @RolesAllowed({"editPlace"})
    public Response insertPlace(Place tr){
        return Response.ok(ps.insertPlace(tr)).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/updatePlace")
    @RolesAllowed({"editPlace"})
    public Response updatePlace(Place tr){
        return Response.ok(ps.updatePlace(tr)).build();
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id_place}")
    @RolesAllowed({"editPlace"})
    public Response deletePlace(@PathParam("id_place") Long id_place){
        ps.deletePlace(id_place);
        return Response.ok().build();
    }

}
