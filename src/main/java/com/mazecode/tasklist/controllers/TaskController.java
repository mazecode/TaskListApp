package com.mazecode.tasklist.controllers;

import com.mazecode.tasklist.models.Task;
import com.mazecode.tasklist.services.TaskService;
import com.mazecode.tasklist.utils.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Class TaskListController
 *
 * @author Diego Feliú <dfeliu@siga98.net> @DFELIU
 */
@RestController
@RequestMapping(path = "/api/tasks", produces = MediaType.APPLICATION_JSON_VALUE)
public class TaskController extends ApiController {

	@Autowired
	private TaskService service;

	/**
	 * @return JsonResponse
	 */
	@GetMapping()
	public ResponseEntity<JsonResponse> index() {
		JsonResponse response = this.response();

		response.setData(this.service.all());
		response.addMessage("All Tasks");
		response.setCode(HttpStatus.OK);

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	/**
	 * @param id of Task
	 *
	 * @return JsonResponse
	 */
	@GetMapping(path = "/{id}")
	public ResponseEntity<JsonResponse> show(@PathVariable("id") Integer id) {
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
	 * @param task new Task
	 *
	 * @return JsonResponse
	 */
	public ResponseEntity<JsonResponse> create(Task task) {
		JsonResponse response = this.response();

		Task temp = this.service.save(task);

		response.setData(temp);
		response.setCode(HttpStatus.CREATED);

		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
}
