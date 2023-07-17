package com.example.pfe.dao;

import com.example.pfe.model.Commentaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICommentaire extends JpaRepository<Commentaire, Long> {
}
