package com.miguelfazio.tutoria.database.repository;

import com.miguelfazio.tutoria.database.entity.Material;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MaterialRepository extends JpaRepository<Material, UUID> {
}
