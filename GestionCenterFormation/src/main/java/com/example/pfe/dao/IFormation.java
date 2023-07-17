package com.example.pfe.dao;

import com.example.pfe.model.Formation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IFormation extends JpaRepository<Formation,Long> {

}
