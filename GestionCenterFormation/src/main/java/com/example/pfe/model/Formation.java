package com.example.pfe.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
public class Formation implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private String supportCours;
    private Date DateDebut;

    private Date dateFin;
    private String motcle;
    private String horaire;
    private String charge;
    private String prix;
    @ManyToMany
    private List<Condidat> condidatList;
    @ManyToOne
    private Formateur formateur;
    @ManyToOne
    private CategorieFormation categorieFormation;
    @OneToMany(mappedBy = "formation")
private List<Commentaire>commentaireList;
@OneToOne
private FichePresence fichePresence;
    public List<Commentaire> getCommentaireList() {
        return commentaireList;
    }

    public void setCommentaireList(List<Commentaire> commentaireList) {
        this.commentaireList = commentaireList;
    }

    public Formateur getFormateur() {
        return formateur;
    }

    public void setFormateur(Formateur formateur) {
        this.formateur = formateur;
    }

    public List<Condidat> getCondidatList() {
        return condidatList;
    }

    public void setCondidatList(List<Condidat> condidatList) {
        this.condidatList = condidatList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CategorieFormation getCategorieFormation() {
        return categorieFormation;
    }

    public void setCategorieFormation(CategorieFormation categorieFormation) {
        this.categorieFormation = categorieFormation;
    }

    public Date getDateDebut() {
        return DateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        DateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public String getMotcle() {
        return motcle;
    }

    public void setMotcle(String motcle) {
        this.motcle = motcle;
    }


    public String getCharge() {
        return charge;
    }

    public void setCharge(String charge) {
        this.charge = charge;
    }


    public String getHoraire() {
        return horaire;
    }

    public void setHoraire(String horaire) {
        this.horaire = horaire;
    }

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

    public String getSupportCours() {
        return supportCours;
    }

    public void setSupportCours(String supportCours) {
        this.supportCours = supportCours;
    }

    public Formation() {
    }

    public Formation(Long id, String supportCours, Date dateDebut, Date dateFin, String motcle, String horaire, String charge, String prix, CategorieFormation categorieFormation) {
        this.id = id;
        this.supportCours = supportCours;
        DateDebut = dateDebut;
        this.dateFin = dateFin;
        this.motcle = motcle;
        this.horaire = horaire;
        this.charge = charge;
        this.prix = prix;
        this.categorieFormation = categorieFormation;
    }
}
