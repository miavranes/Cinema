package org.acme.repository;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.acme.exception.CinemaHall_Exception;
import org.acme.model.CinemaHall;
import org.acme.model.Projection;

import java.util.HashSet;
import java.util.List;


@Dependent
public class CinemaHallRepository {
    @Inject
    private EntityManager em;

    @Transactional
    public CinemaHall createCinemaHall(CinemaHall hall) {
       return  em.merge(hall);
    }

    @Transactional
    public List<CinemaHall> getAllCinemaHalls() {
        List<CinemaHall> halls = em.createNamedQuery(CinemaHall.GET_ALL_CINEMAHALLS, CinemaHall.class).getResultList();

        for (CinemaHall hall : halls) {
            List<Projection> projections = em.createNamedQuery(Projection.GET_PROJECTIONS_FOR_CINEMAHALL, Projection.class)
                    .setParameter("id", hall.getId()).getResultList();
            hall.setProjections(new HashSet<>(projections));
        }
        return halls;
    }


    public List<CinemaHall> getCinemaHallByName(String name) throws CinemaHall_Exception {
        List <CinemaHall> halls = em.createNamedQuery(CinemaHall.GET_CINEMAHALL_BY_NAME, CinemaHall.class)
                .setParameter("name", name).getResultList();

        if (halls.size() == 0){
            throw new CinemaHall_Exception("Ne postoje sale");
        }
        return halls;
    }
}
