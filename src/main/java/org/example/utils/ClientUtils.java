package org.example.utils;

import org.example.entity.Client;

public class ClientUtils {

    public static Client prepareClient(String name) {
        Client client = new Client();
        client.setName(name);
        return client;
    }

    public static Client prepareClient(Long id, String name) {
        Client client = prepareClient(name);
        client.setId(id);
        return client;
    }
}
