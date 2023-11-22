package org.example.utils;

import org.example.entity.Planet;

public class PlanetUtils {
    public static Planet preparePlanet(String name) {
        Planet planet = new Planet();
        planet.setName(name);
        return planet;
    }

    public static Planet preparePlanet(String id, String name) {
        Planet planet = preparePlanet(name);
        planet.setId(id);
        return planet;
    }
}
