package de.gedoplan.ged.angular.www.persistence;

import de.gedoplan.baselibs.persistence.repository.SingleIdEntityRepository;
import de.gedoplan.ged.angular.www.persistence.model.Author;
import de.gedoplan.ged.angular.www.persistence.model.Author_;
import de.gedoplan.ged.angular.www.persistence.model.dto.ListValue;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

/**
 * @author GEDOPLAN, Dominik Mathmann
 */
@ApplicationScoped
@Transactional
public class AuthorRepository extends SingleIdEntityRepository<Integer, Author> {

    public List<ListValue> getListValue() {
        CriteriaQuery<ListValue> query = getCriteriaBuilder().createQuery(ListValue.class);
        Root<Author> root = query.from(Author.class);

        query.select(getCriteriaBuilder().construct(ListValue.class, getCriteriaBuilder().concat(getCriteriaBuilder().concat(root.get(Author_.FIRSTNAME), " "), root.get(Author_.LASTNAME)), root.get(Author_.id)));
        return entityManager.createQuery(query).getResultList();
    }
}
