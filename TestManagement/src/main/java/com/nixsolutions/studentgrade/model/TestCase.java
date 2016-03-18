package com.nixsolutions.studentgrade.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

/**
 * Created by konstantin on 3/15/2016.
 */
@Entity
@Table(name = "testCase")
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

    public TestCase() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAssertion() {
        return assertion;
    }

    public void setAssertion(String assertion) {
        this.assertion = assertion;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Tester getTester() {
        return tester;
    }

    public void setTester(Tester tester) {
        this.tester = tester;
    }

    public Date getAdded() {
        return added;
    }

    public void setAdded(Date added) {
        this.added = added;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}
