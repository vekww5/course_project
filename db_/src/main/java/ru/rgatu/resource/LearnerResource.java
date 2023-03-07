package ru.rgatu.resource;

import ru.rgatu.entity.Learner;
import ru.rgatu.service.LearnerService;

import org.eclipse.microprofile.metrics.MetricUnits;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Gauge;
import org.eclipse.microprofile.metrics.annotation.Timed;

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
    @Counted(name = "getLearnersCount", description = "Количество получения списка учеников")
    @Timed(name = "getLearnersTimer", description = "Скорость выполнения запроса", unit = MetricUnits.MILLISECONDS)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getLearners")
    @RolesAllowed({"watchSSL"})
    public Response getLearners(){
        return Response.ok(ls.getLearners()).build();
    }

    @GET
    @Timed(name = "getLearnerByIdTimer", description = "Скорость выполнения запроса", unit = MetricUnits.MILLISECONDS)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id_learner}")
    public Response getLearnerById(@PathParam("id_learner") Long id_learner){
        return Response.ok(ls.getLearnerById(id_learner)).build();
    }

    @POST
    @Counted(name = "insertLearnerCount", description = "Количество добавленных учеников")
    @Timed(name = "insertLearnerTimer", description = "Скорость добавления ученика", unit = MetricUnits.MILLISECONDS)
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/insertLearner")
    @RolesAllowed({"editLearner", "addLearner"})
    public Response insertLearner(Learner tr){
        return Response.ok(ls.insertLearner(tr)).build();
    }

    @POST
    @Timed(name = "updateLearnerTimer", description = "Скорость изменения ученика", unit = MetricUnits.MILLISECONDS)
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/updateLearner")
    @RolesAllowed({"editLearner"})
    public Response updateLearner(Learner tr){
        return Response.ok(ls.updateLearner(tr)).build();
    }

    @DELETE
    @Counted(name = "deleteLearnerCount", description = "Количество удаленный учеников")
    @Timed(name = "deleteLearnerTimer", description = "Скорость удаления ученика", unit = MetricUnits.MILLISECONDS)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id_learner}")
    @RolesAllowed({"editLearner"})
    public Response deleteLearner(@PathParam("id_learner") Long id_learner){
        ls.deleteLearner(id_learner);
        return Response.ok().build();
    }

}
