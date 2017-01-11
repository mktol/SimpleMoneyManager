package com.mtol.checker.entity;

import javax.persistence.*;

/**
 * This class
 */
@Entity
public class FamilyRequest {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private User From;


    @ManyToOne
    private Family famil;

    public FamilyRequest(User from, User to) {
        From = from;
    }

    public FamilyRequest() {
    }

    public User getFrom() {
        return From;
    }

    public void setFrom(User from) {
        From = from;
    }
    public Family getFamil() {
        return famil;
    }

    public void setFamil(Family famil) {
        this.famil = famil;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
