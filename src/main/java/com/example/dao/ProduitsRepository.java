package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entities.Produit;

public interface ProduitsRepository extends JpaRepository<Produit, Long> {

}
