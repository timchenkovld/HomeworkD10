package org.example.dao;

import org.example.entity.Client;

import java.util.List;

public interface ClientCrudService {
    Client createClient(Client client);

    Client updateClient(Client client);

    Client getClientById(Long clientId);

    List<Client> getAllClients();
    void deleteClientById(Long clientId);
}
