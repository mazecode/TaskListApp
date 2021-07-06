package com.mazecode.tasklist.controllers;

import com.mazecode.tasklist.utils.JsonResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Class HomeController
 *
 * @author Diego Feliú <dfeliu@siga98.net> @DFELIU
 */
@RestController
@RequestMapping("/")
public class HomeController extends ApiController {

	@GetMapping()
	public ResponseEntity<JsonResponse> index() {
		return new ResponseEntity<>(
				this.response()
						.addMessage("Welcome Home")
						.addMessage("MotherFucker!!!!"),
				HttpStatus.OK
		);
	}
}
