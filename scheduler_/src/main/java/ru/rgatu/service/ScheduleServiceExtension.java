package ru.rgatu.service;

import org.eclipse.microprofile.rest.client.annotation.RegisterClientHeaders;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import ru.rgatu.RequestJWTHeaderFactory;
import ru.rgatu.dto.ScheduleDTO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/schedules")
@RegisterRestClient(configKey="db-api")
@RegisterClientHeaders(RequestJWTHeaderFactory.class)
public interface ScheduleServiceExtension {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id_schedule}")
    ScheduleDTO getScheduleById(@PathParam("id_schedule") Long id_schedule);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getSchedules")
    List<Object[]> getSchedules();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("insertSchedule")
    ScheduleDTO insertSchedule(ScheduleDTO lnr);

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("updateSchedule")
    ScheduleDTO updateSchedule(ScheduleDTO lnr);

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id_schedule}")
    void deleteSchedule(@PathParam("id_schedule") Long id_schedule);
}
