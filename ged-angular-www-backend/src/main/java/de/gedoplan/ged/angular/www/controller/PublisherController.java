package de.gedoplan.ged.angular.www.controller;

import de.gedoplan.ged.angular.www.persistence.PublisherRepository;
import de.gedoplan.ged.angular.www.persistence.model.Publisher;
import de.gedoplan.ged.angular.www.persistence.model.dto.ListValue;
import io.swagger.v3.oas.annotations.tags.Tag;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * @author GEDOPLAN, Dominik Mathmann
 */
@Path("publisher")
@Tag(name = "publisher")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PublisherController {

    @Inject
    private PublisherRepository publisherRepository;

    @GET
    @Path("name")
    public List<ListValue> getListValue() {
        return this.publisherRepository.getListValue();
    }

    @GET
    public List<Publisher> getAll() {
        return this.publisherRepository.findAll();
    }
}
