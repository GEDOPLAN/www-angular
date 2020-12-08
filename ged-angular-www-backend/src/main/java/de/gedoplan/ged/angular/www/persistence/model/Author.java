package de.gedoplan.ged.angular.www.persistence.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonView;
import de.gedoplan.baselibs.persistence.entity.GeneratedIntegerIdEntity;
import de.gedoplan.ged.angular.www.persistence.model.views.AuthorOnlyFirstname;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * @author GEDOPLAN, Dominik Mathmann
 */
@Entity
@JsonInclude(Include.NON_NULL)
public class Author extends GeneratedIntegerIdEntity {

    @JsonView(AuthorOnlyFirstname.class)
    @Column(name = "FIRSTNAME")
    private String firstname;

    @Column(name = "LASTNAME")
    private String lastname;

    @ManyToMany(mappedBy = "authors")
    @JsonIgnore
    private List<Book> books;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public List<Book> getBooks() {
        if (books == null) {
            this.books = new ArrayList<>();
        }
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

}
