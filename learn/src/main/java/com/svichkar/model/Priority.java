package com.svichkar.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "priority")
@Data
public class Priority implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "priority",
            nullable = false,
            unique = true,
            length = 255)
    private String priority;

}
