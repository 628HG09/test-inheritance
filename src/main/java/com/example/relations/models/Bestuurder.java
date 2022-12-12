package com.example.relations.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "bestuurders")
public class Bestuurder{
    @Id
    @GeneratedValue
    Long id;

    //  variable declaraties
    private String extraKenmerk;


    @OneToOne
    Voertuig voertuig;

    @OneToMany(mappedBy = "bestuurder")
    List<Rit>ritten;

    @ManyToOne
    UserClass userClass;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExtraKenmerk() {
        return extraKenmerk;
    }

    public void setExtraKenmerk(String extraKenmerk) {
        this.extraKenmerk = extraKenmerk;
    }

    public Voertuig getVoertuig() {
        return voertuig;
    }

    public void setVoertuig(Voertuig voertuig) {
        this.voertuig = voertuig;
    }

    public List<Rit> getRitten() {
        return ritten;
    }

    public UserClass getUserClass() {
        return userClass;
    }

    public void setUserClass(UserClass userClass) {
        this.userClass = userClass;
    }

    //
//    public void setRitten(List<Rit> ritten) {
//        this.ritten = ritten;
//    }
}
