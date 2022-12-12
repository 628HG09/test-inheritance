package com.example.relations.models;

import javax.persistence.*;
import java.util.List;

@Entity
    @Table(name = "userclass")

    public class UserClass {
        @Id
        @GeneratedValue
        private Long id;

        //  variable declaraties
//    @NotNull
//    @Column
        private String voornaam;
        private String achternaam;
        private String gebruikersnaam;
        private String wachtwoord;
        private String email;


        // userclass met hoofdletter?
        @OneToMany(mappedBy = "userClass")
        List<Bestuurder>bestuurders;

        @OneToMany(mappedBy = "userClass")
        List<Passagier>passagiers;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public String getGebruikersnaam() {
            return gebruikersnaam;
        }

        public void setGebruikersnaam(String gebruikersnaam) {
            this.gebruikersnaam = gebruikersnaam;
        }

        public String getWachtwoord() {
            return wachtwoord;
        }

        public void setWachtwoord(String wachtwoord) {
            this.wachtwoord = wachtwoord;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

    public List<Bestuurder> getBestuurders() {
        return bestuurders;
    }

    public List<Passagier> getPassagiers() {
        return passagiers;
    }

    public void setBestuurders(List<Bestuurder> bestuurders) {
        this.bestuurders = bestuurders;
    }

    public void setPassagiers(List<Passagier> passagiers) {
        this.passagiers = passagiers;
    }
}

