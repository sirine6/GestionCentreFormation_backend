package com.example.pfe.dao;

import com.example.pfe.model.FichePresence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IfichePresence extends JpaRepository<FichePresence, Long> {
}
