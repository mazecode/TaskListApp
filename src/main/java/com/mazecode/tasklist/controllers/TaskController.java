package com.mazecode.tasklist.controllers;

import com.mazecode.tasklist.models.Task;
import com.mazecode.tasklist.services.TaskService;
import com.mazecode.tasklist.utils.JsonResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Class TaskListController
 *
 * @author Diego Feliú <diego.feliud@gmail.com> @DFELIU
 */
@RestController
@RequestMapping(path = "/api/v1/tasks", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "Task Rest Controller", description = "REST API Task Controller to Task Entity")
@Log4j
public class TaskController extends ApiController {

    @Autowired
    private TaskService service;

    /**
     * @return JsonResponse
     */
    @Operation(summary = "View a list of available tasks")
    @ApiOperation(value = "View a list of available tasks", response = JsonResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping()
    public ResponseEntity<JsonResponse> index() {
        JsonResponse response = this.response();

        response.setData(this.service.all());
        response.addMessage("All Tasks");
        response.setCode(HttpStatus.OK);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * @param id Long
     * @return JsonResponse
     */
    @GetMapping(path = "/{id}")
    public ResponseEntity<JsonResponse> show(@PathVariable("id") Long id) {
        JsonResponse response = this.response();

        Task temp = this.service.get(id);

        if (null == temp) {
            response.errorTrue(HttpStatus.NOT_FOUND);

            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        response.setData(temp);
        response.addMessage("Found Task " + id);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * @param task Task
     * @return JsonResponse
     */
    @PostMapping(path = "/{task}")
    public ResponseEntity<JsonResponse> create(Task task) {
        JsonResponse response = this.response();

        Task temp = this.service.save(task);

        response.setData(temp);
        response.setCode(HttpStatus.CREATED);
        response.addMessage("Task Created");

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    //

    /**
     * The function receives a PUT request, updates the Todo with the specified Id and returns the updated Todo
     *
     * @param id   Long
     * @param task Task
     * @return JsonResponse
     */
    @PutMapping({"/{id}"})
    public ResponseEntity<JsonResponse> update(@PathVariable("id") Long id, @RequestBody Task task) {
        Task temp = this.service.update(id, task);

        JsonResponse response = this.response();

        if (null == temp) {
            response.errorTrue(HttpStatus.BAD_REQUEST);
            response.addMessage("Task " + id + " Not Updated");

            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        response.setData(temp);
        response.setCode(HttpStatus.OK);
        response.addMessage("Task " + id + " Updated");

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * The function receives a DELETE request, deletes the Todo with the specified Id.
     *
     * @param id Long
     * @return JsonResponse
     */
    @DeleteMapping({"/{id}"})
    public ResponseEntity<JsonResponse> delete(@PathVariable("id") Long id) {
        this.service.delete(id);

        JsonResponse response = this.response();
        response.setCode(HttpStatus.OK);
        response.addMessage("Task " + id + " Deleted");

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
