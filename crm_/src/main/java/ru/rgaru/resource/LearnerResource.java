package ru.rgaru.resource;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import ru.rgaru.dto.LearnerDTO;

import ru.rgaru.service.LearnerService;
import ru.rgaru.service.LearnerServiceExtension;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/learners")
public class LearnerResource {

    @Inject
    LearnerService ls;

    @Inject
    @RestClient
    LearnerServiceExtension lse;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getLearners")
    @RolesAllowed({"watchSSL"})
    public Response getLearners(){
        return Response.ok(lse.getLearners()).build();
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id_learner}")
    public Response getLearnerById(@PathParam("id_learner") Long id_learner){
        return Response.ok(ls.getLearnerById(id_learner)).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/insertLearner")
    @RolesAllowed({"editLearner", "addLearner"})
    public Response insertLearner(LearnerDTO tr){
        return Response.ok(ls.insertLearner(tr)).build();
        //return Response.ok(lse.insertLearner(tr)).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/updateLearner")
    @RolesAllowed({"editLearner"})
    public Response updateLearner(LearnerDTO lnr){
        System.out.println("editLearner");
        return Response.ok(ls.updateLearner(lnr)).build();
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id_learner}")
    @RolesAllowed({"editLearner"})
    public Response deleteLearner(@PathParam("id_learner") Long id_learner){
        ls.deleteLearner(id_learner);
        return Response.ok().build();
    }

}
