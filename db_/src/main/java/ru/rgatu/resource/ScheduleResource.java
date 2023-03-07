package ru.rgatu.resource;

import org.eclipse.microprofile.metrics.MetricUnits;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Timed;
import ru.rgatu.entity.Schedule;
import ru.rgatu.service.ScheduleService;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/schedules")
public class ScheduleResource {

    @Inject
    ScheduleService ssch;

    @GET
    @Counted(name = "getSchedulesCount", description = "Просмотренно расписаний")
    @Timed(name = "getSchedulesTimer", description = "Скорость выполнения запроса", unit = MetricUnits.MILLISECONDS)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getSchedules")
    @RolesAllowed({"watchSSL"})
    public Response getSchedules(){
        return Response.ok(ssch.getSchedules()).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id_schedule}")
    public Response getScheduleById(@PathParam("id_schedule") Long id_schedule){
        return Response.ok(ssch.getScheduleById(id_schedule)).build();
    }

    @POST
    @Counted(name = "insertScheduleCount", description = "Добавлено расписаний")
    @Timed(name = "insertScheduleTimer", description = "Скорость выполнения запроса", unit = MetricUnits.MILLISECONDS)
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/insertSchedule")
    @RolesAllowed({"editSch"})
    public Response insertSchedule(Schedule tr){
        return Response.ok(ssch.insertSchedule(tr)).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/updateSchedule")
    @RolesAllowed({"updateSch", "editSch"})
    public Response updateSchedule(Schedule tr){
        return Response.ok(ssch.updateSchedule(tr)).build();
    }

    @DELETE
    @Counted(name = "deleteScheduleCount", description = "Удалено расписаний")
    @Timed(name = "deleteScheduleTimer", description = "Скорость выполнения запроса", unit = MetricUnits.MILLISECONDS)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id_schedule}")
    @RolesAllowed({"editSch"})
    public Response deleteSchedule(@PathParam("id_schedule") Long id_schedule){
        ssch.deleteSchedule(id_schedule);
        return Response.ok().build();
    }

}
