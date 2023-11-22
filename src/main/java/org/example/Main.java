package org.example;

import org.example.dao.ClientCrudServiceImpl;
import org.example.dao.PlanetCrudServiceImpl;
import org.example.dao.TicketCrudServiceImpl;
import org.example.entity.Client;
import org.example.entity.Planet;
import org.example.entity.Ticket;
import org.example.hibernate.HibernateUtils;
import org.example.utils.ClientUtils;
import org.example.utils.PlanetUtils;
import org.example.utils.TicketUtils;
import org.hibernate.Session;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Session session = HibernateUtils.getInstance().getSessionFactory().openSession();

        ClientCrudServiceImpl clientCrudService = new ClientCrudServiceImpl();
        PlanetCrudServiceImpl planetCrudService = new PlanetCrudServiceImpl();
        TicketCrudServiceImpl ticketCrudService = new TicketCrudServiceImpl();

//        TODO виклики методів для clientCrudService
//        clientCrudService.createClient(ClientUtils.prepareClient("Vlad Tymchenko"));
//        clientCrudService.updateClient(ClientUtils.prepareClient(3L, "Modified Anna"));
//        Client clientById = clientCrudService.getClientById(8L);
//        System.out.println("====> " + clientById);
//        List<Client> allClients = clientCrudService.getAllClients();
//        System.out.println("====> " + allClients);
//        clientCrudService.deleteClientById(6L);

//        TODO виклики методів для planetCrudService
//        planetCrudService.createPlanet(PlanetUtils.preparePlanet("NEPTUNE15", "Neptune15"));
//        planetCrudService.updatePlanet(PlanetUtils.preparePlanet("EARTH", "Modified Earth"));
//        Planet planetById = planetCrudService.getPlanetById("JUPITER");
//        System.out.println("====> " + planetById);
//        List<Planet> allPlanets = planetCrudService.getAllPlanets();
//        System.out.println("====> " + allPlanets);
//        planetCrudService.deleteClientById("MARS23");

//        TODO виклики методів для TicketCrudService
//        ticketCrudService.createTicket(TicketUtils.prepareTicket(clientCrudService.getClientById(2L),
//                planetCrudService.getPlanetById("VENUS11"),
//                planetCrudService.getPlanetById("JUPITER")));
        ticketCrudService.updateTicket(TicketUtils.prepareTicket(ticketCrudService.getTicketById(1L).getId(),
                        clientCrudService.getClientById(2L),
                        planetCrudService.getPlanetById("VENUS11"),
                        planetCrudService.getPlanetById("URANUS455")));
//        Ticket ticketById = ticketCrudService.getTicketById(1L);
//        System.out.println("====> " + ticketById);
//        List<Ticket> allTickets = ticketCrudService.getAllTickets();
//        System.out.println("====> " + allTickets);
//        ticketCrudService.deleteTicketById(9L);
    }
}
