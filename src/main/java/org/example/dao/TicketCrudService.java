package org.example.dao;

import org.example.entity.Ticket;

import java.util.List;

public interface TicketCrudService {
    Ticket createTicket(Ticket ticket);

    Ticket updateTicket(Ticket ticket);

    Ticket getTicketById(Long ticketId);

    List<Ticket> getAllTickets();

    void deleteTicketById(Long ticketId);
}
