package org.acme.repository;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.acme.model.PublicHoliday;

@Dependent
public class PublicHolidayRepository {
    @Inject
    private EntityManager em;

    @Transactional
    public PublicHoliday create(PublicHoliday publicHoliday) {
        return em.merge(publicHoliday);
    }

    public boolean existsByDateAndName(String date, String name) {
        return em
                .createQuery("SELECT COUNT(ph) FROM PublicHoliday ph WHERE ph.date = :date AND ph.name = :name", Long.class)
                .setParameter("date", date)
                .setParameter("name", name)
                .getSingleResult() > 0;
    }
}
