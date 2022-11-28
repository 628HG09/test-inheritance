package com.example.relations.repositories;

import com.example.relations.models.Voertuig;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoertuigRepository extends JpaRepository<Voertuig, Long> {
}
