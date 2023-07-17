package com.example.pfe.dao;

import com.example.pfe.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Iperson extends JpaRepository<Person,Long> {
}
