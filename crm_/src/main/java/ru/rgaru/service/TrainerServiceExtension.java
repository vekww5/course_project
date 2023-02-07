package ru.rgaru.service;

import org.eclipse.microprofile.rest.client.annotation.RegisterClientHeaders;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import ru.rgaru.RequestJWTHeaderFactory;
import ru.rgaru.dto.LearnerDTO;
import ru.rgaru.dto.TrainerDTO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import java.util.List;

@Path("/trainers")
@RegisterRestClient(configKey="db-api")
@RegisterClientHeaders(RequestJWTHeaderFactory.class)
public interface TrainerServiceExtension {
    @GET
    @Path("getTrainers")
    List<TrainerDTO> getTrainers();

    @GET
    @Path("{id_trainer}")
    TrainerDTO getTrainersById(@PathParam("id_trainer") Long id_trainer);

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("insertTrainer")
    TrainerDTO insertTrainer(TrainerDTO tnr);

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("updateTrainer")
    TrainerDTO updateTrainer(TrainerDTO tnr);

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id_trainer}")
    void deleteTrainer(@PathParam("id_trainer") Long id_trainer);
}
