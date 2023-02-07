package ru.rgatu.resource;

import ru.rgatu.entity.Section;
import ru.rgatu.service.SectionService;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/sections")
public class SectionResource {

    @Inject
    SectionService ss;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getSections")
    @RolesAllowed({"watchSSL"})
    public Response getSections(){
        return Response.ok(ss.getSections()).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getSections1")
    @RolesAllowed({"watchSSL"})
    public Response getSections1(){
        return Response.ok(ss.getSections1()).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id_section}")
    public Response getSectionById(@PathParam("id_section") Long id_section){
        return Response.ok(ss.getSectionById(id_section)).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/insertSection")
    @RolesAllowed({"editSection"})
    public Response insertSection(Section tr){
        return Response.ok(ss.insertSection(tr)).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/updateSection")
    @RolesAllowed({"editSection"})
    public Response updateSection(Section tr){
        return Response.ok(ss.updateSection(tr)).build();
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id_section}")
    @RolesAllowed({"editSection"})
    public Response deleteSection(@PathParam("id_section") Long id_section){
        ss.deleteSection(id_section);
        return Response.ok().build();
    }

}
