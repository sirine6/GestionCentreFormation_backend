package com.example.pfe.dao;

import com.example.pfe.model.CategorieFormation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategorieFormation extends JpaRepository<CategorieFormation, Long> {
}
