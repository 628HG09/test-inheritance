package com.example.relations.models;

import javax.persistence.*;

@Entity
@Table(name = "passagiers")
public class Passagier{
    @Id
    @GeneratedValue
    @Column(name = "passagier_id")
    Long id;

    @Column(name = "ritverzoek",
    nullable = false)
    private String ritVerzoek;

    @ManyToOne
    UserClass userClass;

    public String getRitVerzoek() {
        return ritVerzoek;
    }

    public void setRitVerzoek(String ritVerzoek) {
        this.ritVerzoek = ritVerzoek;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public UserClass getUserClass() {
        return userClass;
    }

    public void setUserClass(UserClass userClass) {
        this.userClass = userClass;
    }
}
