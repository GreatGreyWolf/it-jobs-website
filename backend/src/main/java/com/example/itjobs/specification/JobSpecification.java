package com.example.itjobs.specification;

import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.*;

import com.example.itjobs.entity.*;

public class JobSpecification implements Specification<Job> {

    private final String key;
    private final String operation; // This can be "LIKE" or "EQUAL"
    private final Object value;

    public JobSpecification(String key, String operation, Object value) {
        this.key = key;
        this.operation = operation;
        this.value = value;
    }

    @Override
    public Predicate toPredicate(Root<Job> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();

        // Fields from Job entity
        if (key.equals("title") || key.equals("description") || key.equals("todo")) {
            predicates.add(criteriaBuilder.like(root.get(key), "%" + value.toString() + "%"));
        }

        if (key.equals("location")) {
            predicates.add(criteriaBuilder.equal(root.get(key), value.toString()));
        }

        // Fields from related entities
        if (key.equals("role_name")) {
            predicates.add(criteriaBuilder.equal(root.get("role").get("roleName"), value.toString()));
        }

        // table company
        if (key.equals("company_name")) {
            predicates.add(criteriaBuilder.equal(root.get("company").get("companyName"), value.toString()));
        }
        if (key.equals("company_size")) {
            predicates.add(criteriaBuilder.equal(root.get("company").get("companySize"), value.toString()));
        }
        if (key.equals("company_type")) {
            predicates.add(criteriaBuilder.equal(root.get("company").get("companyType"), value.toString()));
        }
        if (key.equals("industry")) {
            predicates.add(criteriaBuilder.equal(root.get("company").get("industry"), value.toString()));
        }

        if (key.equals("employment_type_name")) {
            predicates.add(criteriaBuilder.equal(root.get("employmentType").get("employmentTypeName"),
                    value.toString()));
        }

        if (key.equals("level_name")) {
            predicates.add(
                    criteriaBuilder.equal(root.get("experienceLevel").get("levelName"), value.toString()));
        }

        // Fields from join entities
        if (key.equals("technology_name")) {
            Join<Job, Technology> join = root.join("technologies");
            predicates.add(criteriaBuilder.equal(join.get("technologyName"), value.toString()));
            // Ensure getting unique distinct jobs
            query.distinct(true);
        }

        if (key.equals("method_name")) {
            Join<Job, Method> join = root.join("methods");
            predicates.add(criteriaBuilder.equal(join.get("methodName"), value.toString()));
            // Ensure getting unique distinct jobs
            query.distinct(true);
        }

        if (key.equals("goodie_name")) {
            Join<Job, Goodie> join = root.join("goodies");
            predicates.add(criteriaBuilder.equal(join.get("goodieName"), value.toString()));
            // Ensure getting unique distinct jobs
            query.distinct(true);
        }

        // Fields related to salary and work percentage
        if (key.equals("salary_min")) {
            predicates.add(criteriaBuilder.lessThanOrEqualTo(root.<Integer>get("salaryMax"), (Integer) value));
        }
        if (key.equals("salary_max")) {
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.<Integer>get("salaryMin"), (Integer) value));
        }

        if (key.equals("work_percentage_min")) {
            predicates.add(criteriaBuilder.lessThanOrEqualTo(root.<Integer>get("workPercentageMax"), (Integer) value));
        }
        if (key.equals("work_percentage_max")) {
            predicates
                    .add(criteriaBuilder.greaterThanOrEqualTo(root.<Integer>get("workPercentageMin"), (Integer) value));
        }

        // Combine all predicates using AND
        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
