package ru.rgatu.resource;

import org.eclipse.microprofile.metrics.MetricUnits;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Timed;
import ru.rgatu.entity.Trainer;
import ru.rgatu.service.TrainerService;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/trainers")
public class TrainerResource {

    @Inject
    TrainerService ts;

    @GET
    @Counted(name = "getTrainersCount", description = "Количество получения списка тренеров")
    @Timed(name = "getTrainersTimer", description = "Скорость выполнения запроса", unit = MetricUnits.MILLISECONDS)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getTrainers")
    @RolesAllowed({"watchTH"})
    public Response getTrainers(){
        return Response.ok(ts.getTrainers()).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id_trainer}")
    public Response getTrainerById(@PathParam("id_trainer") Long id_trainer){
        return Response.ok(ts.getTrainerById(id_trainer)).build();
    }

    @POST
    @Counted(name = "insertTrainerCount", description = "Количество добавленных тренеров")
    @Timed(name = "insertTrainerTimer", description = "Скорость выполнения запроса", unit = MetricUnits.MILLISECONDS)
    @Path("/insertTrainer")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed({"editTrainer"})
    public Response insertTrainer(Trainer tr){
        return Response.ok(ts.insertTrainer(tr)).build();
    }

    @POST
    @Path("/updateTrainer")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed({"editTrainer"})
    public Response updateTrainer(Trainer tr){
        return Response.ok(ts.updateTrainer(tr)).build();
    }

    @DELETE
    @Counted(name = "deleteTrainerCount", description = "Количество удаленных тренеров")
    @Timed(name = "deleteTrainerTimer", description = "Скорость выполнения запроса", unit = MetricUnits.MILLISECONDS)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id_trainer}")
    @RolesAllowed({"editTrainer"})
    public Response deleteTrainer(@PathParam("id_trainer") Long id_trainer){
        ts.deleteTrainer(id_trainer);
        return Response.ok().build();
    }

}
