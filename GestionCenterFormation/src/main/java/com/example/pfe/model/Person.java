package com.example.pfe.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity

@Inheritance( strategy = InheritanceType. TABLE_PER_CLASS )
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public abstract class Person implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private String email;
    private  String password ;
    private  String username ;
    private String nom;
    private String prenom;
    private  String adress ;
    private  int numeroTel;
    private String  cv ;
    @OneToMany(mappedBy = "person")
@JsonIgnore
    private List<Reclamation> recalamtions ;

    public List<Reclamation> getRecalamtions() {
        return recalamtions;
    }

    public void setRecalamtions(List<Reclamation> recalamtions) {
        this.recalamtions = recalamtions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int getNumeroTel() {
        return numeroTel;
    }

    public void setNumeroTel(int numeroTel) {
        this.numeroTel = numeroTel;
    }

    public Person() {
    }

    public Person(String email, String password, String username, String nom, String prenom, String adress, int numeroTel, String cv) {
        this.email = email;
        this.password = password;
        this.username = username;
        this.nom = nom;
        this.prenom = prenom;
        this.adress = adress;
        this.numeroTel = numeroTel;
        this.cv = cv;
    }
}
