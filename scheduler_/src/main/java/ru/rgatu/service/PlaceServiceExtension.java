package ru.rgatu.service;

import org.eclipse.microprofile.rest.client.annotation.RegisterClientHeaders;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import ru.rgatu.RequestJWTHeaderFactory;
import ru.rgatu.dto.PlaceDTO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("/places")
@RegisterRestClient(configKey="db-api")
@RegisterClientHeaders(RequestJWTHeaderFactory.class)

public interface PlaceServiceExtension {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id_place}")
    PlaceDTO getPlaceById(@PathParam("id_place") Long id_place);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getPlaces")
    List<PlaceDTO> getPlaces();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("insertPlace")
    PlaceDTO insertPlace(PlaceDTO lnr);

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("updatePlace")
    PlaceDTO updatePlace(PlaceDTO lnr);

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id_place}")
    void deletePlace(@PathParam("id_place") Long id_place);
}
