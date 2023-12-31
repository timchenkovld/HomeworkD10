package org.example.dao;

import org.example.entity.Planet;
import org.example.hibernate.HibernateUtils;
import org.example.utils.PlanetUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Objects;

public class PlanetCrudServiceImpl implements PlanetCrudService{
    private static final String GET_ALL_PLANETS_QUERY = "from Planet";
    @Override
    public Planet createPlanet(Planet planet) {
        try (Session session = HibernateUtils.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                session.persist(planet);
                transaction.commit();
                return planet;
            } catch (Exception e) {
                e.printStackTrace();
                transaction.rollback();
                return null;
            }
        }
    }

    @Override
    public Planet updatePlanet(Planet planet) {
        if (Objects.isNull(planet.getId())) {
            return null;
        }
        try (Session session = HibernateUtils.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                session.merge(planet);
                transaction.commit();
                return planet;
            } catch (Exception e) {
                e.printStackTrace();
                transaction.rollback();
                return null;
            }
        }
    }

    @Override
    public Planet getPlanetById(String planetId) {
        try (Session session = HibernateUtils.getInstance().getSessionFactory().openSession()) {
            return session.get(Planet.class, planetId);
        }
    }

    @Override
    public List<Planet> getAllPlanets() {
        try (Session session = HibernateUtils.getInstance().getSessionFactory().openSession()) {
            return session.createQuery(GET_ALL_PLANETS_QUERY, Planet.class).list();
        }
    }

    @Override
    public void deleteClientById(String planetId) {
        try(Session session = HibernateUtils.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Planet planet = session.get(Planet.class, planetId);
            session.remove(planet);
            transaction.commit();
        }
    }
}
