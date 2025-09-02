package org.example.unicode.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
public class Unicode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "code_point", nullable = false)
    private Integer unicode;
    @Column(name = "ch", nullable = false)
    private Character character;
    @Column(name = "subscription", nullable = false)
    private String subscription;
}
