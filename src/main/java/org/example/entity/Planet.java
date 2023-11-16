package org.example.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.ColumnTransformer;

@Data
@Entity
@Table(name = "planet")
public class Planet {
    @Id
    @Column(nullable = false)
    @ColumnTransformer(write = "UPPER(?)")
    private String id;

    @Column(length = 500, nullable = false)
    @Size(min = 1, max = 500)
    private String name;
}

