package org.example.utils;

import org.example.entity.Client;
import org.example.entity.Planet;
import org.example.entity.Ticket;

import java.time.LocalDateTime;

public class TicketUtils {

    public static Ticket prepareTicket(Client client, Planet fromPlanet, Planet toPlanet) {
        Ticket ticket = new Ticket();
        ticket.setCreatedAt(LocalDateTime.now());
        ticket.setClient(client);
        ticket.setFromPlanet(fromPlanet);
        ticket.setToPlanet(toPlanet);
        return ticket;
    }

    public static Ticket prepareTicket(Long id, Client client, Planet fromPlanet, Planet toPlanet) {
        Ticket ticket = prepareTicket(client, fromPlanet, toPlanet);
        ticket.setId(id);
        return ticket;
    }
}
