package com.nixsolutions.studentgrade.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by konstantin on 3/15/2016.
 */
@Entity
@Table(name = "priority")
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

    public Priority() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }
}
