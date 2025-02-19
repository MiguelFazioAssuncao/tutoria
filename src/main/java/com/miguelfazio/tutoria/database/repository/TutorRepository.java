package com.miguelfazio.tutoria.database.repository;

import com.miguelfazio.tutoria.database.entity.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TutorRepository extends JpaRepository<Tutor, UUID> {
}
