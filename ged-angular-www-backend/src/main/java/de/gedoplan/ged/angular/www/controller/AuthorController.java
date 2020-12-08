package de.gedoplan.ged.angular.www.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.gedoplan.ged.angular.www.persistence.AuthorRepository;
import de.gedoplan.ged.angular.www.persistence.model.Author;
import de.gedoplan.ged.angular.www.persistence.model.dto.ListValue;
import de.gedoplan.ged.angular.www.persistence.model.views.AuthorOnlyFirstname;
import io.swagger.v3.oas.annotations.tags.Tag;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.List;

/**
 * @author GEDOPLAN, Dominik Mathmann
 */
@Path("author")
@Tag(name = "author")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AuthorController {

    @Inject
    private AuthorRepository authorRepository;

    @Inject
    private ObjectMapper mapper;

    @GET
    @JsonView(AuthorOnlyFirstname.class)
    public List<Author> getAuthorNames() {
        return this.authorRepository.findAll();
    }

    @GET
    @Path("name")
    public List<ListValue> getAuthorList() {
        return this.authorRepository.getListValue();
    }

    @POST
    @Path("{id}")
    public void updateAuthorName(@PathParam("id") Integer id, String json) throws IOException {
        Author author = this.authorRepository.findById(id);
        author = mapper.readerForUpdating(author).withView(AuthorOnlyFirstname.class).readValue(json);
        this.authorRepository.merge(author);
    }

}
