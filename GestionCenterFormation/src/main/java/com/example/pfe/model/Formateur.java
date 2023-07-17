package com.example.pfe.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Formateur  extends Person{
private String specailite ;
private  String salair;
private  int note;
@OneToMany(mappedBy ="formateur" )
@JsonIgnore
private List<Formation>formationList;

    public List<Formation> getFormationList() {
        return formationList;
    }

    public void setFormationList(List<Formation> formationList) {
        this.formationList = formationList;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public String getSpecailite() {
        return specailite;
    }

    public void setSpecailite(String specailite) {
        this.specailite = specailite;
    }

    public String getSalair() {
        return salair;
    }

    public void setSalair(String salair) {
        this.salair = salair;
    }

    public Formateur() {
    }

    public Formateur(String email, String password, String username, String nom, String prenom, String adress, int numeroTel, String cv, String specailite, String salair, int note) {
        super(email, password, username, nom, prenom, adress, numeroTel, cv);
        this.specailite = specailite;
        this.salair = salair;
        this.note = note;
    }
}
