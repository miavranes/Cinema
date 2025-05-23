package org.acme.repository;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.acme.model.CountryInfo;

@Dependent
public class CountryRepository {

    @Inject
    private EntityManager em;

    @Transactional
    public CountryInfo create(CountryInfo info) {
        return em.merge(info);
    }
}
