package com.svichkar.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tester")
public class Tester implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name",
            nullable = false,
            length = 255)
    private String name;

    @Column(name = "lastName",
            nullable = false,
            length = 255)
    private String lastName;

}
