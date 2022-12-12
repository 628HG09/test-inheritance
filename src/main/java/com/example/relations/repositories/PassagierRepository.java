package com.example.relations.repositories;

import com.example.relations.models.Passagier;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

public interface PassagierRepository extends JpaRepository<Passagier, Long> {
}
