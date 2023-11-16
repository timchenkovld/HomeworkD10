package org.example;

import org.example.dao.ClientCrudServiceImpl;
import org.example.dao.PlanetCrudService;
import org.example.dao.PlanetCrudServiceImpl;
import org.example.entity.Client;
import org.example.entity.Planet;
import org.example.hibernate.HibernateUtils;
import org.hibernate.Session;

import java.util.List;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        Session session = HibernateUtils.getInstance().getSessionFactory().openSession();

        ClientCrudServiceImpl clientCrudService = new ClientCrudServiceImpl();
        PlanetCrudService planetCrudService = new PlanetCrudServiceImpl();

//        TODO виклики методів для clientCrudService
        clientCrudService.createClient(prepareClient("Vlad Tymchenko"));
//        clientCrudService.updateClient(prepareClient(3L, "Modified Anna"));
//        Client clientById = clientCrudService.getClientById(8L);
//        System.out.println("====> " + clientById);
//        List<Client> allClients = clientCrudService.getAllClients();
//        System.out.println("====> " + allClients);
//        clientCrudService.deleteClientById(6L);

//        TODO виклики методів для planetCrudService
//        planetCrudService.createPlanet(preparePlanet("NEPTUNE15", "Neptune15"));
//        planetCrudService.updatePlanet(preparePlanet("EARTH", "Modified Earth"));
//        Planet planetById = planetCrudService.getPlanetById("JUPITER");
//        System.out.println("====> " + planetById);
//        List<Planet> allPlanets = planetCrudService.getAllPlanets();
//        System.out.println("====> " + allPlanets);
//        planetCrudService.deleteClientById("MARS23");
    }
    private static Client prepareClient(String name){
        Client client = new Client();
        client.setName(name);
        return client;
    }
    private static Client prepareClient(Long id, String name){
        Client client =prepareClient(name);
        client.setId(id);
        return client;
    }

    private static Planet preparePlanet(String name){
        Planet planet = new Planet();
        planet.setName(name);
        return planet;
    }

    private static Planet preparePlanet(String id, String name){
        Planet planet = preparePlanet(name);
        planet.setId(id);
        return planet;
    }
}
