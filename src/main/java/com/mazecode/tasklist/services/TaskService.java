package com.mazecode.tasklist.services;

import com.mazecode.tasklist.models.Task;
import com.mazecode.tasklist.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Class TaskService
 *
 * @author Diego Feliú <dfeliu@siga98.net> @DFELIU
 */
@Service
public class TaskService {
	@Autowired
	private TaskRepository repository;

	/**
	 * @return List<Task>
	 */
	public List<Task> all() {
		return this.repository.findAll();
	}

	/**
	 * @param id of Task to find
	 *
	 * @return Task|null
	 */
	public Task get(int id) {
		return this.repository.findById(id).orElse(null);
	}

	/**
	 * @param task Task to create
	 *
	 * @return Task
	 */
	public Task save(Task task) {
		return this.repository.save(task);
	}
}
