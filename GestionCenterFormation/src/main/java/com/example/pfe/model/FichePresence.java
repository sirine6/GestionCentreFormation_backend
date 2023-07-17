package com.example.pfe.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class FichePresence implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private Date date;
    private String totalpresence;
    @OneToMany(mappedBy = "fichePresence")
    private List<Condidat>condidatList;
    @OneToOne
    private  Formation formation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTotalpresence() {
        return totalpresence;
    }

    public void setTotalpresence(String totalpresence) {
        this.totalpresence = totalpresence;
    }

    public List<Condidat> getCondidatList() {
        return condidatList;
    }

    public void setCondidatList(List<Condidat> condidatList) {
        this.condidatList = condidatList;
    }

    public Formation getFormation() {
        return formation;
    }

    public void setFormation(Formation formation) {
        this.formation = formation;
    }

    public FichePresence() {
    }

    public FichePresence(Long id, Date date, String totalpresence) {
        this.id = id;
        this.date = date;
        this.totalpresence = totalpresence;
    }
}
