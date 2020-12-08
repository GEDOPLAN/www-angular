package de.gedoplan.ged.angular.www.persistence;

import de.gedoplan.baselibs.persistence.repository.SingleIdEntityRepository;
import de.gedoplan.ged.angular.www.persistence.model.Publisher;
import de.gedoplan.ged.angular.www.persistence.model.Publisher_;
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
public class PublisherRepository extends SingleIdEntityRepository<Integer, Publisher> {

    public List<ListValue> getListValue() {
        CriteriaQuery<ListValue> query = getCriteriaBuilder().createQuery(ListValue.class);
        Root<Publisher> root = query.from(Publisher.class);

        query.select(getCriteriaBuilder().construct(ListValue.class, root.get(Publisher_.name), root.get(Publisher_.id)));
        return entityManager.createQuery(query).getResultList();
    }
}
