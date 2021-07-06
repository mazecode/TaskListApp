package com.mazecode.tasklist.repositories;

import com.mazecode.tasklist.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Class TaskRepository
 *
 * @author Diego Feliú <diego.feliud@gmail.com> @DFELIU
 */
@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
