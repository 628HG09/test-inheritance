package com.example.relations.repositories;

import com.example.relations.models.UserClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserClassRepository extends JpaRepository<UserClass, Long> {
}
