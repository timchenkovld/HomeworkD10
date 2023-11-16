package org.example.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "client_id", nullable = false)
    private Long clientId;

    @Column(name = "from_planet_id", nullable = false)
    private String fromPlanetId;

    @Column(name = "to_planet_id", nullable = false)
    private String toPlanetId;
}
