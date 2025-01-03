package com.hexagonal.tasks.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexagonal.tasks.infrastructure.entities.TaskEntity;

@Repository
public interface JpaTaskRepository extends JpaRepository<TaskEntity, Long> {

}
