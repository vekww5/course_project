package ru.rgatu.service;

import org.eclipse.microprofile.rest.client.annotation.RegisterClientHeaders;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import ru.rgatu.RequestJWTHeaderFactory;
import ru.rgatu.dto.HeaderScheduleDTO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/headerschedules")
@RegisterRestClient(configKey="db-api")
@RegisterClientHeaders(RequestJWTHeaderFactory.class)
public interface HeaderScheduleServiceExtension {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id_header_schedule}")
    HeaderScheduleDTO getHeaderScheduleById(@PathParam("id_header_schedule") Long id_header_schedule);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getHeaderSchedules")
    List<HeaderScheduleDTO> getHeaderSchedules();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("insertHeaderSchedule")
    HeaderScheduleDTO insertHeaderSchedule(HeaderScheduleDTO lnr);

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("updateHeaderSchedule")
    HeaderScheduleDTO updateHeaderSchedule(HeaderScheduleDTO lnr);

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id_HeaderSchedule}")
    void deleteHeaderSchedule(@PathParam("id_HeaderSchedule") Long id_HeaderSchedule);
}
