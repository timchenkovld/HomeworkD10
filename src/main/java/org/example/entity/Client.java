package org.example.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 200, nullable = false)
    @Size(min = 3, max = 200)
    private String name;

    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Ticket> tickets;
}
