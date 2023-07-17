package com.example.pfe.dao;

import com.example.pfe.model.Avis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAvis extends JpaRepository<Avis, Long> {

}
