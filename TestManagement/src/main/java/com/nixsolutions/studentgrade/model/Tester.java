package com.nixsolutions.studentgrade.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by konstantin on 3/15/2016.
 */
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
