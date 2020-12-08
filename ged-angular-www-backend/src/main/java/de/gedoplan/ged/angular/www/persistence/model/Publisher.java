package de.gedoplan.ged.angular.www.persistence.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import de.gedoplan.baselibs.persistence.entity.GeneratedIntegerIdEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * @author GEDOPLAN, Dominik Mathmann
 */
@Entity
@JsonInclude(Include.NON_NULL)
public class Publisher extends GeneratedIntegerIdEntity {


    @Column(name = "NAME")
    @JsonProperty("publisherName")
    private String name;

    @OneToMany(mappedBy = "publisher")
    @JsonIgnore
    private List<Book> books;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

}
