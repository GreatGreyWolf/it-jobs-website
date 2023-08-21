package com.example.itjobs.specification;

import org.springframework.data.jpa.domain.Specification;

import java.util.Collection;

import javax.persistence.criteria.*;
import javax.persistence.metamodel.PluralAttribute;

import com.example.itjobs.entity.*;

public class JobSpecification implements Specification<Job> {

    private final String key;
    private final String operation;
    private final Object value;

    public JobSpecification(String key, String operation, Object value) {
        this.key = key;
        this.operation = operation;
        this.value = value;
    }

    @Override
    public Predicate toPredicate(Root<Job> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        Path<?> path = resolvePath(root, key, query);

        switch (operation) {
            case "LIKE":
                return criteriaBuilder.like(path.as(String.class), "%" + value.toString() + "%");
            case "EQUAL":
                return criteriaBuilder.equal(path, value.toString());
            case "GREATER_THAN_OR_EQUAL":
                return criteriaBuilder.greaterThanOrEqualTo(path.as(Integer.class), Integer.parseInt(value.toString()));
            case "LESS_THAN_OR_EQUAL":
                return criteriaBuilder.lessThanOrEqualTo(path.as(Integer.class), Integer.parseInt(value.toString()));
            default:
                return null; // TODO: throw an exception for unsupported operations
        }
    }

    private Path<?> resolvePath(Root<Job> root, String attributePath, CriteriaQuery<?> query) {
        String[] paths = attributePath.split("\\.");
        Path<?> path;

        // If the path contains more than one segment, indicating a deeper attribute
        // (for example company.name or methods.methodName)
        if (paths.length > 1) {
            // Check if the attribute (like 'methods') is of type Collection
            if (Collection.class.isAssignableFrom(root.get(paths[0]).getJavaType())) {
                // It's a ManyToMany relationship, need a join
                Join<Object, Object> join = root.join(paths[0]);
                path = join.get(paths[1]);
                query.distinct(true); // When joining a collection, ensure unique results
            } else {
                // Simple attribute or an embedded object
                path = root.get(paths[0]).get(paths[1]);
            }
        } else {
            // Direct attribute of the Job entity
            path = root.get(paths[0]);
        }

        return path;
    }

}
