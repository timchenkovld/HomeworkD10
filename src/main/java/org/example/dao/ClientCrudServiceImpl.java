package org.example.dao;

import org.example.entity.Client;
import org.example.hibernate.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Objects;

public class ClientCrudServiceImpl implements ClientCrudService {
    private static final String GET_ALL_CLIENTS_QUERY = "from Client";
    @Override
    public Client createClient(Client client) {
        try (Session session = HibernateUtils.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                client.setId(null);
                session.persist(client);
                transaction.commit();
                return client;
            } catch (Exception e) {
                e.printStackTrace();
                transaction.rollback();
                return null;
            }
        }
    }

    @Override
    public Client updateClient(Client client) {
        if (Objects.isNull(client.getId())) {
            return null;
        }
        try (Session session = HibernateUtils.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                session.merge(client);
                transaction.commit();
                return client;
            } catch (Exception e) {
                e.printStackTrace();
                transaction.rollback();
                return null;
            }
        }
    }

    @Override
    public Client getClientById(Long clientId) {
        try (Session session = HibernateUtils.getInstance().getSessionFactory().openSession()) {
            return session.get(Client.class, clientId);
        }
    }

    @Override
    public List<Client> getAllClients() {
        try (Session session = HibernateUtils.getInstance().getSessionFactory().openSession()) {
            return session.createQuery(GET_ALL_CLIENTS_QUERY, Client.class).list();
        }
    }

    @Override
    public void deleteClientById(Long clientId) {
        try(Session session = HibernateUtils.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Client client = session.get(Client.class, clientId);
            session.remove(client);
            transaction.commit();
        }
    }
}
