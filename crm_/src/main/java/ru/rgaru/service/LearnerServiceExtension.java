package ru.rgaru.service;

import org.eclipse.microprofile.rest.client.annotation.RegisterClientHeaders;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import ru.rgaru.RequestJWTHeaderFactory;
import ru.rgaru.dto.LearnerDTO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.List;

@Path("/learners")
@RegisterRestClient(configKey="db-api")
@RegisterClientHeaders(RequestJWTHeaderFactory.class)
public interface LearnerServiceExtension {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id_learner}")
    LearnerDTO getLearnerById(@PathParam("id_learner") Long id_learner);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getLearners")
    List<Object[]> getLearners();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("insertLearner")
    LearnerDTO insertLearner(LearnerDTO lnr);

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("updateLearner")
    LearnerDTO updateLearner(LearnerDTO lnr);

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id_learner}")
    void deleteLearner(@PathParam("id_learner") Long id_learner);
}
