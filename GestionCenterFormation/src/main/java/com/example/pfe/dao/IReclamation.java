package com.example.pfe.dao;

import com.example.pfe.model.Reclamation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IReclamation extends JpaRepository <Reclamation,Long>{
}
