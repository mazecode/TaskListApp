package com.mazecode.tasklist.controllers;

import com.mazecode.tasklist.utils.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Class ApiController
 *
 * @author Diego Feliú <diego.feliud@gmail.com> @DFELIU
 */
@RestController
@RequestMapping("/api/v1")
public class ApiController {
	@Autowired
	private JsonResponse response;

	public JsonResponse response() {
		this.response.clearMessages();
		return this.response;
	}
}
