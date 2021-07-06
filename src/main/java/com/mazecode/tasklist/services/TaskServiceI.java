package com.mazecode.tasklist.services;

import com.mazecode.tasklist.models.Task;

import java.util.List;

public interface TaskServiceI {
    List<Task> all();

    Task get(Long id);

    Task save(Task task);

    Task update(Long id, Task task);

    void delete(Long id);

    void addComment(Long id, String comment);

//    void
}
