package com.svichkar.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "testCase")
@Data
public class TestCase implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name",
            nullable = false,
            unique = true,
            length = 255)
    private String name;

    @Column(name = "description",
            nullable = false,
            length = 255)
    private String description;

    @Column(name = "assertion",
            nullable = false,
            length = 512)
    private String assertion;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "priority_id", nullable = false)
    private Priority priority;

    @Column(name = "comment",
            length = 512)
    private String comment;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tester_id", nullable = false)
    private Tester tester;

    @Column(name = "added",
            length = 32, nullable = false)
    private Date added;

    @Column(name = "updated",
            length = 32)
    private Date updated;

}
