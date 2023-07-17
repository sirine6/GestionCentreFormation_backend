package com.example.pfe.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

public class Avis {
    @Id
    @GeneratedValue
    private String id;

    private int raiting;
    @ManyToOne
    private Formateur formateur;
    @OneToMany
    private Condidat condidat;

    public String getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getRaiting() {
        return raiting;
    }

    public void setRaiting(int raiting) {
        this.raiting = raiting;
    }

    public Formateur getFormateur() {
        return formateur;
    }

    public void setFormateur(Formateur formateur) {
        this.formateur = formateur;
    }

    public Condidat getCondidat() {
        return condidat;
    }

    public void setCondidat(Condidat condidat) {
        this.condidat = condidat;
    }

    public Avis() {

    }

    public Avis(String id, int raiting) {
        this.id = id;
        this.raiting = raiting;
    }
}
