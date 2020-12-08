package de.gedoplan.ged.angular.www.persistence.model.dto;

import de.gedoplan.ged.angular.www.persistence.model.Author;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "cdi")
public interface AuthorMapper {
    default String authorsToString(List<Author> authors) {
        return authors.stream().map(a -> a.getFirstname() + " " + a.getLastname()).collect(Collectors.joining(", "));
    }
}
