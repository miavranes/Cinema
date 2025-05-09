package org.acme.repository;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.acme.model.WeatherEntity;

@Dependent
public class WeatherRepository {

    @Inject
    private EntityManager em;

    @Transactional
    public WeatherEntity create(WeatherEntity weather) {
        return em.merge(weather);
    }

    public boolean checkCityName(String name){
        return em.createQuery("SELECT COUNT(w) FROM WeatherEntity w WHERE w.cityName = :name", Long.class).setParameter("name", name).getSingleResult() > 0;
    }
}
