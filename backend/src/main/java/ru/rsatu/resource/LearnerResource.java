package ru.rsatu.resource;

import ru.rsatu.pojo.Learner;
import ru.rsatu.service.LearnerService;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/learners")
public class LearnerResource {

    @Inject
    LearnerService ls;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getLearners")
    @RolesAllowed({"watchSSL"})
    public Response getLearners(){
        return Response.ok(ls.getLearners()).build();
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
    public Response insertLearner(Learner tr){
        return Response.ok(ls.insertLearner(tr)).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/updateLearner")
    @RolesAllowed({"editLearner"})
    public Response updateLearner(Learner tr){
        return Response.ok(ls.updateLearner(tr)).build();
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
