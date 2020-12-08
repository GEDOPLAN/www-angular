package de.gedoplan.ged.angular.www.persistence.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import de.gedoplan.baselibs.persistence.entity.GeneratedIntegerIdEntity;
import de.gedoplan.ged.angular.www.persistence.utils.JPAResolver;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author GEDOPLAN, Dominik Mathmann
 */
@Entity
@JsonInclude(Include.NON_NULL)
public class Book extends GeneratedIntegerIdEntity {

    @Column(name = "TITLE")
    private String title;

    @Column(name = "PAGES")
    private Integer pageCount;

    @Column(name = "CODE")
    private String isbn;

    @ManyToOne
    @JoinColumn(name = "PUBLISHER")
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id",
            resolver = JPAResolver.class,
            scope = Publisher.class
    )
    @JsonIdentityReference(alwaysAsId = true)
    private Publisher publisher;

    @ManyToMany
    @JsonIdentityInfo(
            resolver = JPAResolver.class,
            scope = Author.class,
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id"
    )
    @JsonIdentityReference(alwaysAsId = true)
    private List<Author> authors;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public List<Author> getAuthors() {
        if (authors == null) {
            this.authors = new ArrayList<>();
        }
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }


}
