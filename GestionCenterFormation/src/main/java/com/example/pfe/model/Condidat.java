package com.example.pfe.model;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

@Entity
public class Condidat extends Person {
    private String niveaux;
    private String travail;
    private Date dateinscription;
    @OneToMany(mappedBy = "condidat")
    private List<Commentaire> commentaireList;

    public List<Commentaire> getCommentaireList() {
        return commentaireList;
    }

    public void setCommentaireList(List<Commentaire> commentaireList) {
        this.commentaireList = commentaireList;
    }

    @ManyToOne
    private FichePresence fichePresence;

    public FichePresence getFichePresence() {
        return fichePresence;
    }

    public void setFichePresence(FichePresence fichePresence) {
        this.fichePresence = fichePresence;
    }

    @ManyToMany(mappedBy = "condidatList")
private List<Formation> formationList;

    public List<Formation> getFormationList() {
        return formationList;
    }

    public void setFormationList(List<Formation> formationList) {
        this.formationList = formationList;
    }

    public String getNiveaux() {
        return niveaux;
    }

    public void setNiveaux(String niveaux) {
        this.niveaux = niveaux;
    }

    public String getTravail() {
        return travail;
    }

    public void setTravail(String travail) {
        this.travail = travail;
    }

    public Date getDateinscription() {
        return dateinscription;
    }

    public void setDateinscription(Date dateinscription) {
        this.dateinscription = dateinscription;
    }

    public Condidat(String email, String password, String username, String nom, String prenom, String adress, int numeroTel, String cv, String niveaux, String travail, Date dateinscription) {
        super(email, password, username, nom, prenom, adress, numeroTel, cv);
        this.niveaux = niveaux;
        this.travail = travail;
        this.dateinscription = dateinscription;
    }

    public Condidat() {
    }
}
