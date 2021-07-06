package com.mazecode.tasklist.repositories;

import com.mazecode.tasklist.models.TaskList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Class TaskListRepository
 *
 * @author Diego Feliú <diego.feliud@gmail.com> @DFELIU
 */
@Repository
public interface TaskListRepository extends JpaRepository<TaskList, Long> {
}