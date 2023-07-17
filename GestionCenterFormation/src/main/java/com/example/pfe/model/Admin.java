package com.example.pfe.model;

import javax.persistence.Entity;

@Entity
public class Admin extends  Person{
    public Admin(String email, String password, String username, String nom, String prenom, String adress, int numeroTel, String cv) {
        super(email, password, username, nom, prenom, adress, numeroTel, cv);
    }

    public Admin() {
    }
}
