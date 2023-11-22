package org.example.dao;

import org.example.entity.Client;
import org.example.entity.Ticket;
import org.example.hibernate.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Objects;

public class TicketCrudServiceImpl implements TicketCrudService{
    private static final String GET_ALL_TICKETS_QUERY = "from Ticket";
    @Override
    public Ticket createTicket(Ticket ticket) {
        try (Session session = HibernateUtils.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                ticket.setId(null);
                session.persist(ticket);
                transaction.commit();
                return ticket;
            } catch (Exception e) {
                e.printStackTrace();
                transaction.rollback();
                return null;
            }
        }
    }

    @Override
    public Ticket updateTicket(Ticket ticket) {
        if (Objects.isNull(ticket.getId())) {
            return null;
        }
        try (Session session = HibernateUtils.getInstance().getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            try {
                session.merge(ticket);
                transaction.commit();
                return ticket;
            } catch (Exception e) {
                e.printStackTrace();
                transaction.rollback();
                return null;
            }
        }
    }

    @Override
    public Ticket getTicketById(Long ticketId) {
        try (Session session = HibernateUtils.getInstance().getSessionFactory().openSession()) {
            return session.get(Ticket.class, ticketId);
        }
    }

    @Override
    public List<Ticket> getAllTickets() {
        try (Session session = HibernateUtils.getInstance().getSessionFactory().openSession()) {
            return session.createQuery(GET_ALL_TICKETS_QUERY, Ticket.class).list();
        }
    }

    @Override
    public void deleteTicketById(Long ticketId) {
        try(Session session = HibernateUtils.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Ticket ticket = session.get(Ticket.class, ticketId);
            session.remove(ticket);
            transaction.commit();
        }
    }
}
