package com.example.pfe.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Commentaire {
    @Id
    @GeneratedValue
    private Long id;
    private String contenu;
    private Date datecomentaire;
@ManyToOne
private  Condidat condidat;

    public Commentaire(Long id, String contenu, Date datecomentaire, Condidat condidat, Formation formation) {
        this.id = id;
        this.contenu = contenu;
        this.datecomentaire = datecomentaire;
        this.condidat = condidat;
        this.formation = formation;
    }

    @ManyToOne
    @JsonIgnore
   private  Formation formation;

    public Condidat getCondidat() {
        return condidat;
    }

    public void setCondidat(Condidat condidat) {
        this.condidat = condidat;
    }

    public Formation getFormation() {
        return formation;
    }

    public void setFormation(Formation formation) {
        this.formation = formation;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public Date getDatecomentaire() {
        return datecomentaire;
    }

    public void setDatecomentaire(Date datecomentaire) {
        this.datecomentaire = datecomentaire;
    }

    public Commentaire() {
    }

}
