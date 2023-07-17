package com.example.pfe.dao;

import com.example.pfe.model.Condidat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICondidat extends JpaRepository<Condidat,Long> {
}
