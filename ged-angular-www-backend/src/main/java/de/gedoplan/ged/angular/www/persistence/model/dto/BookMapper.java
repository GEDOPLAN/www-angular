package de.gedoplan.ged.angular.www.persistence.model.dto;

import de.gedoplan.ged.angular.www.persistence.model.Author;
import de.gedoplan.ged.angular.www.persistence.model.Book;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author GEDOPLAN, Dominik Mathmann
 */
@Mapper(componentModel = "cdi", uses = {AuthorMapper.class})
public interface BookMapper {

    BookOverviewDTO bookToOverviewDTO(Book book);

    List<BookOverviewDTO> bookToOverviewDTO(List<Book> book);

    class BookOverviewDTO {

        private Integer id;

        private String title;

        private String isbn;

        private String authors;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getIsbn() {
            return isbn;
        }

        public void setIsbn(String isbn) {
            this.isbn = isbn;
        }

        public String getAuthors() {
            return authors;
        }

        public void setAuthors(String authors) {
            this.authors = authors;
        }
    }

}
