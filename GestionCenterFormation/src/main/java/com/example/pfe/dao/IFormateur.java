package com.example.pfe.dao;

import com.example.pfe.model.Formateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFormateur extends JpaRepository<Formateur,Long> {
}
