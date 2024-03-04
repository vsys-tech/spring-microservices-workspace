package postgre.app.specifications;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import postgre.app.entities.Employee;

public class EmployeeSpecification implements Specification<Employee> {

    private final SearchCriteria criteria;

    public EmployeeSpecification(SearchCriteria criteria) {
        this.criteria = criteria;
    }

    @Override
    public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        if (criteria.ops().equals("=")) {
            return builder.equal(
                    root.get(criteria.key()), criteria.value().toString()
            );

        }
        return null;
    }
}
