package org.example.dao;

import org.example.entity.Planet;

import java.util.List;

public interface PlanetCrudService {
    boolean createPlanet(Planet planet);

    boolean updatePlanet(Planet planet);

    Planet getPlanetById(String planetId);

    List<Planet> getAllPlanets();

    void deleteClientById(String planetId);
}
