package com.mazecode.tasklist.services;

import com.mazecode.tasklist.models.Task;
import com.mazecode.tasklist.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Class TaskService
 *
 * @author Diego Feliú <diego.feliud@gmail.com> @DFELIU
 */
@Service
public class TaskService implements TaskServiceI {

    @Autowired
    private TaskRepository repository;

    /**
     * @return List<Task>
     */
    @Override
    public List<Task> all() {
        List<Task> tasks = new ArrayList<>();

        this.repository.findAll().forEach(tasks::add);

        return tasks;
    }

    /**
     * @param id of Task to find
     * @return Task|null
     */
    @Override
    public Task get(Long id) {
        return this.repository.findById(id).orElse(null);
    }

    /**
     * @param task Task to create
     * @return Task
     */
    @Override
    public Task save(Task task) {
        return this.repository.save(task);
    }

    /**
     *
     * @param id
     * @param task
     *
     * @return Task
     */
    @Override
    public Task update(Long id, Task task) {
        Task taskFromDb = this.repository.findById(id).orElse(null);

		assert taskFromDb != null;

		System.out.println(taskFromDb.toString());

        taskFromDb.setState(task.getState());
        taskFromDb.setDescription(task.getDescription());
        taskFromDb.setTitle(task.getTitle());

        return this.repository.save(taskFromDb);
    }


    /**
     * @param id
     */
    @Override
    public void delete(Long id) {
        this.repository.deleteById(id);
    }
}
