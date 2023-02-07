package ru.rgatu.service;

import org.eclipse.microprofile.rest.client.annotation.RegisterClientHeaders;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import ru.rgatu.RequestJWTHeaderFactory;
import ru.rgatu.dto.SectionDTO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/sections")
@RegisterRestClient(configKey="db-api")
@RegisterClientHeaders(RequestJWTHeaderFactory.class)

public interface SectionServiceExtension {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id_section}")
    SectionDTO getSectionById(@PathParam("id_section") Long id_section);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getSections")
    List<Object[]> getSections();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("insertSection")
    SectionDTO insertSection(SectionDTO lnr);

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("updateSection")
    SectionDTO updateSection(SectionDTO lnr);

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id_section}")
    void deleteSection(@PathParam("id_section") Long id_section);
}
