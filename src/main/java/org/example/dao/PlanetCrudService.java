package org.example.dao;

import org.example.entity.Planet;

import java.util.List;

public interface PlanetCrudService {
    Planet createPlanet(Planet planet);

    Planet updatePlanet(Planet planet);

    Planet getPlanetById(String planetId);

    List<Planet> getAllPlanets();

    void deleteClientById(String planetId);
}
