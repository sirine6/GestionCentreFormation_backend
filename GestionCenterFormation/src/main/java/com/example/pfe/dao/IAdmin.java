package com.example.pfe.dao;

import com.example.pfe.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IAdmin  extends JpaRepository<Admin,Long>{
}
