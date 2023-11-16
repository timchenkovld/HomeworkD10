package org.example.hibernate;

import lombok.Getter;
import org.example.entity.Client;
import org.example.entity.Planet;
import org.example.entity.Ticket;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.example.props.PropertyReader;
import org.flywaydb.core.Flyway;

public class HibernateUtils {
    private static final HibernateUtils INSTANCE = new HibernateUtils();

    @Getter
    private SessionFactory sessionFactory;

    private HibernateUtils() {
        this.sessionFactory = new Configuration()
                .addAnnotatedClass(Client.class)
                .addAnnotatedClass(Planet.class)
                .addAnnotatedClass(Ticket.class)
                .buildSessionFactory();

        flywayMigration(PropertyReader.getConnectionUrlForPostgres(),
                PropertyReader.getUserForPostgres(),
                PropertyReader.getPasswordForPostgres());
    }

    public static HibernateUtils getInstance() {
        return INSTANCE;
    }

    public void closeSessionFactory() {
        this.sessionFactory.close();
    }

    private void flywayMigration(String connectionUrl, String username, String password) {
        Flyway flyway = Flyway.configure()
                .dataSource(connectionUrl, username, password)
                .load();
        flyway.migrate();
    }
}
