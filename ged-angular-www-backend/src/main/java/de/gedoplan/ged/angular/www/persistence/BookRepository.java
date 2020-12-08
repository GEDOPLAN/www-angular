package de.gedoplan.ged.angular.www.persistence;

import de.gedoplan.baselibs.persistence.repository.SingleIdEntityRepository;
import de.gedoplan.ged.angular.www.persistence.model.Book;
import de.gedoplan.ged.angular.www.persistence.model.Book_;
import de.gedoplan.ged.angular.www.persistence.model.dto.BookMapper;
import de.gedoplan.ged.angular.www.persistence.model.dto.BookMapper.BookOverviewDTO;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityGraph;
import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;

/**
 * @author GEDOPLAN, Dominik Mathmann
 */
@ApplicationScoped
@Transactional
public class BookRepository extends SingleIdEntityRepository<Integer, Book> {

    @Inject
    BookMapper overviewMapper;

    public List<BookOverviewDTO> getBookOverview() {
        List<Book> all = findAll();
        return overviewMapper.bookToOverviewDTO(all);
    }


    public Book loadDetails(Integer id) {
        HashMap<String, Object> hints = new HashMap<>();
        EntityGraph<Book> graph = entityManager.createEntityGraph(Book.class);
        graph.addAttributeNodes(Book_.authors);
        hints.put("javax.persistence.fetchgraph", graph);

        return findById(id, hints);
    }


}
