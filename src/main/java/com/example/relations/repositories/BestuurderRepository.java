package com.example.relations.repositories;

import com.example.relations.models.Bestuurder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BestuurderRepository extends JpaRepository<Bestuurder, Long> {
    List<Bestuurder> findAllBestuurdersByAchternaamEqualsIgnoreCase(String achternaam);
}
