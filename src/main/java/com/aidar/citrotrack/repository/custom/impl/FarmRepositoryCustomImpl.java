package com.aidar.citrotrack.repository.custom.impl;


import com.aidar.citrotrack.model.Farm;
import com.aidar.citrotrack.repository.custom.FarmRepositoryCustom;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FarmRepositoryCustomImpl implements FarmRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Farm> searchFarms(Map<String, Object> criteria) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Farm> query = cb.createQuery(Farm.class);
        Root<Farm> farmRoot = query.from(Farm.class);

        List<Predicate> predicates = new ArrayList<>();

        if (criteria.containsKey("name")) {
            predicates.add(cb.like(cb.lower(farmRoot.get("name")), "%" + criteria.get("name").toString().toLowerCase() + "%"));
        }

        if (criteria.containsKey("location")) {
            predicates.add(cb.like(cb.lower(farmRoot.get("location")), "%" + criteria.get("location").toString().toLowerCase() + "%"));
        }

        if (criteria.containsKey("minArea")) {
            predicates.add(cb.greaterThanOrEqualTo(farmRoot.get("totalArea"), (Double) criteria.get("minArea")));
        }

        if (criteria.containsKey("maxArea")) {
            predicates.add(cb.lessThanOrEqualTo(farmRoot.get("totalArea"), (Double) criteria.get("maxArea")));
        }

        if (criteria.containsKey("creationDateFrom")) {
            predicates.add(cb.greaterThanOrEqualTo(farmRoot.get("creationDate"), (LocalDate) criteria.get("creationDateFrom")));
        }

        if (criteria.containsKey("creationDateTo")) {
            predicates.add(cb.lessThanOrEqualTo(farmRoot.get("creationDate"), (LocalDate) criteria.get("creationDateTo")));
        }

        query.where(cb.and(predicates.toArray(new Predicate[0])));

        return entityManager.createQuery(query).getResultList();
    }
}
