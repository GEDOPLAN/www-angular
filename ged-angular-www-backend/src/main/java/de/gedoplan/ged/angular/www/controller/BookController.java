package de.gedoplan.ged.angular.www.controller;

import de.gedoplan.ged.angular.www.persistence.BookRepository;
import de.gedoplan.ged.angular.www.persistence.model.Book;
import de.gedoplan.ged.angular.www.persistence.model.dto.BookMapper;
import io.swagger.v3.oas.annotations.tags.Tag;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * @author GEDOPLAN, Dominik Mathmann
 */
@Path("book")
@Tag(name = "book")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BookController {

    @Inject
    private BookRepository repository;

    @GET
    public List<BookMapper.BookOverviewDTO> getBooks() {
        return repository.getBookOverview();
    }

    @GET
    @Path("{id}")
    public Book getBook(@PathParam("id") Integer id) {
        return repository.loadDetails(id);
    }

    @PUT
    public void saveBook(Book book) {
        repository.merge(book);
    }

    @DELETE
    @Path("{id}")
    public void deleteBook(@PathParam("id") Integer id) {
        repository.removeById(id);
    }
}
