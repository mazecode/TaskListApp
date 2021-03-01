package com.mazecode.tasklist.repositories;

import com.mazecode.tasklist.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Integer> {
}
