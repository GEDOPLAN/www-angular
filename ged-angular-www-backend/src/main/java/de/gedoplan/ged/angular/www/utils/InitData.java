package de.gedoplan.ged.angular.www.utils;

import de.gedoplan.ged.angular.www.persistence.AuthorRepository;
import de.gedoplan.ged.angular.www.persistence.BookRepository;
import de.gedoplan.ged.angular.www.persistence.PublisherRepository;
import de.gedoplan.ged.angular.www.persistence.model.Author;
import de.gedoplan.ged.angular.www.persistence.model.Book;
import de.gedoplan.ged.angular.www.persistence.model.Publisher;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

/**
 * @author GEDOPLAN, Dominik Mathmann
 */
@ApplicationScoped
public class InitData {

    @Inject
    BookRepository bookRepository;

    @Inject
    PublisherRepository publisherRepository;

    @Inject
    AuthorRepository authorRepository;

    public void init(@Observes @Initialized(ApplicationScoped.class) Object init) {

        long countAll = authorRepository.countAll() + publisherRepository.countAll();
        if (countAll == 0) {
            Publisher p01 = new Publisher();
            p01.setName("entwickler.press");
            p01 = publisherRepository.merge(p01);

            Publisher p02 = new Publisher();
            p02.setName("Rheinwerk Computing");
            p02 = publisherRepository.merge(p02);

            Publisher p03 = new Publisher();
            p03.setName("dpunkt");
            p03 = publisherRepository.merge(p03);

            Author a01 = new Author();
            a01.setFirstname("Dirk");
            a01.setLastname("Weil");
            a01 = this.authorRepository.merge(a01);

            Author a02 = new Author();
            a02.setFirstname("Adam");
            a02.setLastname("Bean");
            a02 = this.authorRepository.merge(a02);

            Book b01 = new Book();
            b01.getAuthors().add(a01);
            b01.getAuthors().add(a02);
            b01.setPublisher(p01);
            b01.setIsbn("978-3868021035");
            b01.setPageCount(316);
            b01.setTitle("Java EE 7: Enterprise-Anwendungsentwicklung leicht gemacht");
            b01 = this.bookRepository.merge(b01);
        }
    }
}
